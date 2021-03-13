package com.balionis.kotlin15.service1

import com.balionis.kotlin15.common.MoshiExtensions.jsonAdapter
import com.balionis.kotlin15.common.MyRequest
import com.balionis.kotlin15.common.MyResponse
import com.balionis.kotlin15.common.MyResponsePayload
import mu.KotlinLogging
import kotlin.system.exitProcess

private val logger = KotlinLogging.logger {}

private val requestAdapter = MyRequest::class.java.jsonAdapter()
private val responseAdapter = MyResponse::class.java.jsonAdapter()

fun main(args: Array<String>) {
    logger.info { "main: args=${args.joinToString()}" }

    runCatching {
        App(Configuration.load()).let {
            Runtime.getRuntime().addShutdownHook(
                Thread {
                    logger.info { "main: closing" }
                    it.close()
                    logger.info { "main: closed" }
                }
            )
        }
    }.onFailure {
        logger.error(it) { "main: unhandled exception ${it.message}" }
        exitProcess(1)
    }
}

class App(private val config: Configuration) : AutoCloseable {

    fun echo(reqJson: String): String {
        logger.debug { "echo: reqJson=$reqJson" }

        val req = requestAdapter.fromJson(reqJson)

        val arg1 = req?.payload?.args?.getOrElse(0) { "${config.application.port}" }

        val res = MyResponse(MyResponsePayload("echo:$arg1"))

        val resJson = responseAdapter.toJson(res)

        logger.debug { "echo: resJson=$resJson" }

        return resJson
    }

    override fun close() {
        logger.debug { "close+" }
    }
}
