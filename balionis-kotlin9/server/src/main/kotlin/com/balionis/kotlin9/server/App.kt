package com.balionis.kotlin9.server

import mu.KotlinLogging

import com.balionis.kotlin9.client.MyRequest
import com.balionis.kotlin9.client.MyRequestPayload
import com.balionis.kotlin9.client.MyResponse
import com.balionis.kotlin9.client.MyResponsePayload
import com.balionis.kotlin9.client.MoshiExtensions.jsonAdapter

private val logger = KotlinLogging.logger {}

private val requestAdapter = MyRequest::class.java.jsonAdapter()
private val responseAdapter = MyResponse::class.java.jsonAdapter()

object App {

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

fun main(args: Array<String>) {

    logger.info { "main: args=${args.joinToString()}" }

    val req = MyRequest(MyRequestPayload(args.asList()))

    val reqJson = requestAdapter.toJson(req)

    logger.debug { "main: reqJson=${reqJson}" }

    val resJson = App.echo(reqJson)

    logger.debug { "main: resJson=${resJson}" }

    val res = responseAdapter.fromJson(resJson)

    logger.info { "main: done. msg=${res?.payload?.message}" }

}
