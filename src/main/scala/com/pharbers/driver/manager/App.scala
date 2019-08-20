package com.pharbers.driver.manager

import java.io.{File, PrintWriter}
import java.util.UUID

import com.pharbers.driver.manager.DriverManager.ProcessManager
import com.pharbers.driver.manager.model.DriverConfig
import com.pharbers.driver.manager.util.JsonHandler
import com.pharbers.kafka.consumer.PharbersKafkaConsumer
import com.pharbers.kafka.schema.SparkDriverConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.logging.log4j.LogManager

/**
  * Hello world!
  *
  */
object App extends App {
    private var open = true
    val logger = LogManager.getLogger(this.getClass)
    val pkc = new PharbersKafkaConsumer[String, SparkDriverConfig](List(Config.REQUEST_TOPIC), 1000, Int.MaxValue, process)
    val t = new Thread(pkc)
    Runtime.getRuntime.addShutdownHook(new Thread(){
        override def run(): Unit = {
            logger.info("DriverServer close")
            pkc.close()
            ProcessManager.clean()
        }
    })
    try {
        logger.info("DriverServer starting!")
        logger.info(Config.REQUEST_TOPIC)
        t.start()
        var cmd = Console.readLine()
        while (cmd != "exit") {
            cmd = Console.readLine()
        }
    } catch {
        case ie: InterruptedException =>
            logger.error(ie.getMessage)
    } finally {
        pkc.close()
        ProcessManager.clean()
        logger.info("close!")
    }

    def process(record: ConsumerRecord[String, SparkDriverConfig]): Unit = {
        val log =  LogManager.getRootLogger
        log.info(s"接收到kafka消息， key：${record.key()}，value：${record.value()}")
        val config = DriverConfig()
        config.name = record.value().getName.toString
        config.topic = record.value().getTopic.toString
        config.cup = record.value().getCup.toString.toInt
        config.eme = record.value().getEme.toString.toInt
        val file = new File(Config.DRIVER_FILE_PATH + s"config_${UUID.randomUUID().toString.replaceAll("-", "")}.json")
        log.debug(file.getAbsolutePath)
        file.deleteOnExit()
        file.createNewFile()
        val writer = new PrintWriter(file)
        //todo: ObjectMapper全局唯一
        writer.println(JsonHandler.handler.writeValueAsString(config))
        writer.close()
        val command = s"java -jar ${Config.DRIVER_JAR_PATH} ${file.getAbsolutePath}"
        log.info(command)
        val driverProcess = Runtime.getRuntime.exec(command)
        ProcessManager.addProcess(config.name, driverProcess)
    }
}
