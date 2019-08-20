package com.pharbers.driver.manager.log

import org.apache.logging.log4j.{LogManager, Logger}

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/07/31 15:15
  * @note 需要打印log就继承这个类
  */
trait Logable {
    val logger: Logger = LogManager.getLogger(this.getClass)
}
