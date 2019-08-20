package com.pharbers

import java.io.RandomAccessFile
import java.nio.channels.FileChannel

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/08/09 10:20
  * @note 一些值得注意的地方
  */
object test extends App {
    val filename = "test"
    val file = new RandomAccessFile(filename, "rw")
    val fc = file.getChannel
    val size = fc.size().toInt
    val mapBuf = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024)
    var offset = 0
    while (true) {
        val fl = fc.lock()
        mapBuf.position(0)
        if (mapBuf.remaining() > 0) {
            val len = mapBuf.remaining()
            val buff = new Array[Byte](1024)
            mapBuf.get(buff, offset, len)
            println(new String(buff))
        }
        fl.release()
        Thread.sleep(1000)
    }
}

object test2 extends App {
    val filename = "test"
    val file = new RandomAccessFile(filename, "rw")
    val fc = file.getChannel
    val size = fc.size().toInt
    val mapBuf = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024)
//    while (true) {
        val fl = fc.lock()
        mapBuf.position(0)
        for (a <- 0 to 1023) {
            mapBuf.put(a, 0.toByte)
        }

        val buff = Math.random().toString.getBytes
        mapBuf.put(buff)

        fl.release()
        file.close()
//        Thread.sleep(1000)
//    }
}
