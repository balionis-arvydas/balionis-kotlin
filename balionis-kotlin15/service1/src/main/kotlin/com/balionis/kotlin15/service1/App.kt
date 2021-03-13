package com.balionis.kotlin15.service1

import mu.KotlinLogging

import com.balionis.kotlin15.common.MyRequest
import com.balionis.kotlin15.common.MyRequestPayload
import com.balionis.kotlin15.common.MyResponse
import com.balionis.kotlin15.common.MyResponsePayload
import com.balionis.kotlin15.common.MoshiExtensions.jsonAdapter

private val logger = KotlinLogging.logger {}

private val requestAdapter = MyRequest::class.java.jsonAdapter()
private val responseAdapter = MyResponse::class.java.jsonAdapter()

fun main(args: Array<String>) {

    logger.info { "main: args=${args.joinToString()}" }

    val req = MyRequest(MyRequestPayload(args.asList()))

    val reqJson = requestAdapter.toJson(req)

    logger.debug { "main: reqJson=${reqJson}" }

    val app = App()

    val resJson = app.echo(reqJson)

    logger.debug { "main: resJson=${resJson}" }

    val res = responseAdapter.fromJson(resJson)

    logger.info { "main: done. msg=${res?.payload?.message}" }

}

class App {

    fun echo(reqJson: String): String {
        logger.debug { "echo: reqJson=${reqJson}" }

        val req = requestAdapter.fromJson(reqJson)

        val arg1 = req?.payload?.args?.getOrElse(0) { "default" }

        val res = MyResponse(MyResponsePayload("echo:$arg1"))

        val resJson = responseAdapter.toJson(res)

        logger.debug { "echo: resJson=${resJson}" }

        return resJson
    }
}