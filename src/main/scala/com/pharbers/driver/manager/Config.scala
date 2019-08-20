package com.pharbers.driver.manager

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/07/30 19:44
  * @note 一些值得注意的地方
  */
object Config {
    //todo: 配置化
//    final val DRIVER_JAR_PATH = scala.util.Properties.envOrElse("DRIVER_JAR_PATH", "D:\\code\\pharbers\\ipaas-data-driver\\target\\ipaas-data-driver-0.1-jar-with-dependencies.jar")
    final val DRIVER_JAR_PATH = scala.util.Properties.envOrElse("DRIVER_JAR_PATH", "/home/spark/config/sparkDriverManager/ipaas-data-driver.jar")
    final val REQUEST_TOPIC = scala.util.Properties.envOrElse("REQUEST_TOPIC", "DriverRequest")
//    final val DRIVER_FILE_PATH = scala.util.Properties.envOrElse("DRIVER_FILE_PATH", System.getProperty("java.io.tmpdir"))
    final val DRIVER_FILE_PATH = scala.util.Properties.envOrElse("DRIVER_FILE_PATH", "/home/spark/config/sparkDriverManager/")
    final val DRIVER_MAPPED_SIZE = scala.util.Properties.envOrElse("DRIVER_MAPPED_SIZE", "1024").toInt
    final val JOB_RECALL_TOPIC = scala.util.Properties.envOrElse("JOB_RECALL_TOPIC", "job_recall")
    final val JOB_RECALL_CHANNEL = scala.util.Properties.envOrElse("JOB_RECALL_CHANNEL", "tm/")
}
