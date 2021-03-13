package com.balionis.kotlin15.service1

import org.junit.Test
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun testMe() {
        val req =
            """
            {"payload":{"args":[]}}
            """.trimIndent()

        val expected =
            """
            {"payload":{"message":"echo:8080"}}
            """.trimIndent()

        val subject = App(Configuration.load())
        val actual = subject.echo(req)

        assertEquals(expected, actual)
    }
}
