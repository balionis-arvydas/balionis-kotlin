package com.balionis.kotlin5

import org.junit.Test
import kotlin.test.assertEquals

class AppTest {
    @Test
    fun testMe() {
        val actual = App.echo("arg1")
        assertEquals("arg1", actual)
    }
}
