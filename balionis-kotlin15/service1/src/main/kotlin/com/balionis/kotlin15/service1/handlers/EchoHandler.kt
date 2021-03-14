package com.balionis.kotlin15.service1.handlers

import com.balionis.kotlin15.common.MoshiExtensions.jsonAdapter
import com.balionis.kotlin15.common.MyRequest
import com.balionis.kotlin15.common.MyRequestPayload
import com.balionis.kotlin15.common.MyResponse
import com.balionis.kotlin15.common.MyResponsePayload
import mu.KotlinLogging
import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status

private val requestAdapter = MyRequest::class.java.jsonAdapter()
private val responseAdapter = MyResponse::class.java.jsonAdapter()

private val logger = KotlinLogging.logger {}

val echoHandler: HttpHandler = { request: Request ->
    logger.info("echoHandler: body=${request.body}")

    val req = requestAdapter.fromJson(request.bodyString()) ?: MyRequest(MyRequestPayload(emptyList()))

    val arg1 = req.payload.args.getOrElse(0) { "default" }

    val res = MyResponse(MyResponsePayload("echo:$arg1"))

    val resJson = responseAdapter.toJson(res)

    logger.info("echoHandler: resJson=$resJson")

    Response(Status.Companion.OK).body(resJson)
}
