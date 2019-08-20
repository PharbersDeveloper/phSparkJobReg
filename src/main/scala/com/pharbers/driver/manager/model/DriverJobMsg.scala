package com.pharbers.driver.manager.model

import scala.beans.BeanProperty

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/08/12 14:04
  * @note 一些值得注意的地方
  */
case class DriverJobMsg() {
    @BeanProperty
    var jobId = ""
    @BeanProperty
    var status = ""
    @BeanProperty
    var msg = ""
}
