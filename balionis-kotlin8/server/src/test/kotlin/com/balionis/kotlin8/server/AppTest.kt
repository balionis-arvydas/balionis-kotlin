package com.balionis.kotlin8.server

import kotlin.test.assertEquals
import org.junit.Test

class AppTest {
    @Test
    fun testMe() {
        val req = """{"payload":{"args":["arg1","arg2"]}}"""

        val expected = """{"payload":{"message":"echo:arg1"}}"""
        val actual = App.echo(req)

        assertEquals(expected, actual)
    }
}
