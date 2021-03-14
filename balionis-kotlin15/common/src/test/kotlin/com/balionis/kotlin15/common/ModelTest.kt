package com.balionis.kotlin15.common

import com.balionis.kotlin15.common.MoshiExtensions.jsonAdapter
import org.junit.Test
import kotlin.test.assertEquals

private val requestAdapter = MyRequest::class.java.jsonAdapter()
private val responseAdapter = MyResponse::class.java.jsonAdapter()

class ModelTest {
    @Test
    fun testRequest() {
        val expected =
            """
            {"payload":{"args":["arg1","arg2"]}}
            """.trimIndent()

        val subject = MyRequest(MyRequestPayload(listOf("arg1", "arg2")))

        val actual = requestAdapter.toJson(subject)

        assertEquals(expected, actual)
    }

    @Test
    fun testResponse() {
        val expected =
            """
            {"payload":{"message":"arg1"}}
            """.trimIndent()

        val subject = MyResponse(MyResponsePayload("arg1"))

        val actual = responseAdapter.toJson(subject)

        assertEquals(expected, actual)
    }
}
