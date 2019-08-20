package com.pharbers.driver.manager.DriverManager

import java.io.{BufferedReader, File, InputStreamReader}
import java.util.concurrent.ConcurrentHashMap

import com.pharbers.driver.manager.Config
import com.pharbers.driver.manager.log.Logable
import com.pharbers.driver.manager.model.DriverJobMsg
import com.pharbers.driver.manager.util.{JsonHandler, MappedReader}
import com.pharbers.kafka.producer.PharbersKafkaProducer
import com.pharbers.kafka.schema.{Header, SparkJobRecall}
import org.apache.log4j.{LogManager, Logger}

import scala.collection.JavaConverters._


/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/07/31 15:06
  * @note 一些值得注意的地方
  */
object ProcessManager extends Logable {
    private val processMap: java.util.Map[String, Process] = new ConcurrentHashMap[String, Process]()
    val pkp = new PharbersKafkaProducer[String, SparkJobRecall]

    def addProcess(id: String, process: Process): Unit ={
        if(processMap.containsKey(id)){
            //todo: 暂时是关闭重复的
            logger.info(s"close $id")
            processMap.get(id).destroy()
        }
        //todo： 配置最大上限
        if (processMap.size() > 2){
            //todo: recall driver数量到达上限
            logger.info("获得driver数量到达上限")
        }else{
            processMap.put(id, process)
            new Thread(new ProcessListener(id, process)).start()
        }
    }

    def clean(): Unit ={
        logger.info(s"clean all map")
        processMap.values.asScala.foreach(x => x.destroy())
        pkp.producer.close()
    }

    def closeOne(id: String): Unit ={
        logger.info(s"lose $id")
        //todo: 直接杀进程似乎不安全，需要让进程自己退出
        if (processMap.containsKey(id)) processMap.get(id).destroy()
        processMap.remove(id)
    }

    class ProcessListener(id: String, process: Process) extends Runnable with Logable {
        override def run(): Unit = {
            val inputReader = new BufferedReader(new InputStreamReader(process.getInputStream))
            val errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream))
            val file = new File(Config.DRIVER_FILE_PATH + id)
            file.deleteOnExit()
            file.createNewFile()
            val mappedReader = MappedReader(file, Config.DRIVER_MAPPED_SIZE)
            while (process.isAlive){
                val msg = mappedReader.readAll()
                while (inputReader.ready()) logger.info(s"drive id: $id, inputMsg: ${inputReader.readLine()}")
                while (errorReader.ready()) logger.info(s"drive id: $id, errorMsg: ${errorReader.readLine()}")
                if (msg.startsWith("{")){
                    //todo: 解析msg 并发送给mqtt
                    val jobMsg = JsonHandler.readJson[DriverJobMsg](msg)
                    logger.info(s"driver id: $id, jobid: ${jobMsg.jobId}, status: ${jobMsg.status}, msg: ${jobMsg.msg}")
                    jobMsg.status match {
                        case "error" =>
                            logger.info(s"发送错误信息")
                        case "1" =>
                            logger.info(s"发送结束信息")
                        case _ =>
                            logger.info(s"未定义消息")
                    }
                    ProcessManager.pkp.produce(Config.JOB_RECALL_TOPIC, jobMsg.jobId,
                        new SparkJobRecall(new Header(Config.JOB_RECALL_CHANNEL), JsonHandler.handler.writeValueAsString(jobMsg)))
                }
                //降低轮询消耗
                Thread.sleep(1000)
            }
            ProcessManager.closeOne(id)
            file.deleteOnExit()
        }
    }
}
