package com.balionis.kotlin3

import kotlin.test.assertEquals
import org.junit.Test

class HandlerTest {
    @Test
    fun testMe() {
        val handler = Handler()
        val res = handler.handleRequest("Lambda", null)
        assertEquals("Hello, Lambda from Kotlin", res)
    }
}