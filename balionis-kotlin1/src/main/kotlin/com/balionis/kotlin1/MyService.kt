package com.balionis.kotlin1

import com.google.inject.Inject
import com.google.inject.name.Named
import org.slf4j.LoggerFactory

interface MyService {
    fun echo(msg: String): String
}

class MyServiceImpl @Inject constructor(@Named("MyServiceName")  val name:String) : MyService {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(MyServiceImpl::class.java)
    }

    override fun echo(msg: String): String {
        val res = "$name:$msg"

        LOGGER.info("echo={}", res)

        return res
    }
}