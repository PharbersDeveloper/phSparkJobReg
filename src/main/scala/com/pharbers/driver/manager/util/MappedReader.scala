package com.pharbers.driver.manager.util

import java.io.{File, RandomAccessFile}
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/08/12 13:32
  * @note 一些值得注意的地方
  */
case class MappedReader(file: File, size: Int) {
    val randomFile: RandomAccessFile = new RandomAccessFile(file, "rw")
    val fc: FileChannel = randomFile.getChannel
    val mapBuf: MappedByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, size)

    def readAll(): String ={
        val fl = fc.lock()
        mapBuf.position(0)
        val buff = new Array[Byte](size)
        if (mapBuf.remaining() > 0) {
            val len = mapBuf.remaining()
            mapBuf.get(buff, 0, len)
        }
        clean()
        fl.release()
        new String(buff)
    }

    def clean(): Unit ={
        for (i <- 0 until size) {
            mapBuf.put(i, 0.toByte)
        }
    }
}
