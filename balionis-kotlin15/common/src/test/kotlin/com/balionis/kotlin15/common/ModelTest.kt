package com.balionis.kotlin15.common

import com.balionis.kotlin15.common.MoshiExtensions.jsonAdapter
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.string.shouldContain

private val requestAdapter = MyRequest::class.java.jsonAdapter()
private val responseAdapter = MyResponse::class.java.jsonAdapter()

class ModelTest : AnnotationSpec() {

    @Test
    fun testRequestToJson() {
        val expected =
            """
            {"payload":{"args":["arg1","arg2"]}}
            """.trimIndent()

        val subject = MyRequest(MyRequestPayload(listOf("arg1", "arg2")))

        val actual = requestAdapter.toJson(subject)

        actual shouldContain expected
    }

    @Test
    fun testRequestFromJson() {
        val json =
            """
            {"payload":{"args":["arg1","arg2"]}}
            """.trimIndent()

        val expected = listOf("arg1", "arg2")

        val request = requestAdapter.fromJson(json)

        request!!.payload.args shouldContainAll expected
    }

    @Test
    fun testResponseToJson() {
        val expected =
            """
            {"payload":{"message":"arg1"}}
            """.trimIndent()

        val subject = MyResponse(MyResponsePayload("arg1"))

        val actual = responseAdapter.toJson(subject)

        actual shouldContain expected
    }

    @Test
    fun testResponseFromJson() {
        val json =
            """
            {"payload":{"message":"arg1"}}
            """.trimIndent()

        val expected = "arg1"
        val response = responseAdapter.fromJson(json)

        response!!.payload.message shouldContain expected
    }
}
