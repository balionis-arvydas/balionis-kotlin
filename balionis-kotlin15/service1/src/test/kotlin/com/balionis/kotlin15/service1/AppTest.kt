package com.balionis.kotlin15.service1

import org.junit.Test
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun testMe() {
        val req =
            """
            {"payload":{"args":["arg1","arg2"]}}
            """.trimIndent()

        val expected =
            """
            {"payload":{"message":"echo:arg1"}}
            """.trimIndent()

        val subject = App()
        val actual = subject.echo(req)

        assertEquals(expected, actual)
    }
}
