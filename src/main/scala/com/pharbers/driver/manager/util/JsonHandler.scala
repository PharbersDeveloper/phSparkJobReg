package com.pharbers.driver.manager.util

import scala.reflect.ClassTag
import java.io.ByteArrayInputStream
import org.codehaus.jackson.map.ObjectMapper



/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/07/31 18:50
  * @note 一些值得注意的地方
  */
object JsonHandler {
    val handler = new ObjectMapper()

    def readJson[T: ClassTag](json: String): T ={
        handler.readValue(json.getBytes(), implicitly[ClassTag[T]].runtimeClass).asInstanceOf[T]
    }
}
