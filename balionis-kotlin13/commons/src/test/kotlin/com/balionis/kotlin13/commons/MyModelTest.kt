package com.balionis.kotlin13.commons

import com.balionis.kotlin13.commons.MoshiExtensions.jsonAdapter
import kotlin.test.assertEquals
import org.junit.Test

private val requestAdapter = MyRequest::class.java.jsonAdapter()

class MyModelTest {
    @Test
    fun testMe() {
        val model = MyRequest(MyRequestPayload(listOf("myarg1", "myarg2")))
        val actual = requestAdapter.toJson(model)
        val expected = "{\"payload\":{\"args\":[\"myarg1\",\"myarg2\"]}}"
        assertEquals(expected, actual)
    }
}
