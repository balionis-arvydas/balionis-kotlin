package com.balionis.kotlin15.service1

import kotlin.test.assertEquals
import org.junit.Test

class AppTest {
    @Test
    fun testMe() {
        val req = """{"payload":{"args":["arg1","arg2"]}}"""

        val expected = """{"payload":{"message":"echo:arg1"}}"""

        val subject = App()
        val actual = subject.echo(req)

        assertEquals(expected, actual)
    }
}
