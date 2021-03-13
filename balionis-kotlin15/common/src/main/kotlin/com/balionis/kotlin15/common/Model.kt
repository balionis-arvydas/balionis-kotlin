package com.balionis.kotlin15.common

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyRequestPayload(val args: List<String>)

@JsonClass(generateAdapter = true)
data class MyRequest(val payload: MyRequestPayload)

@JsonClass(generateAdapter = true)
data class MyResponsePayload(val message: String)

@JsonClass(generateAdapter = true)
data class MyResponse(val payload: MyResponsePayload)
