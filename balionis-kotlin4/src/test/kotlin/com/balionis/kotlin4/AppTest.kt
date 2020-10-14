package com.balionis.kotlin4

import kotlin.test.assertEquals
import org.junit.Test

class AppTest {
    @Test
    fun testMe() {
        val res = App.echo(listOf("test"))
        assertEquals("echo:test", res)
    }

    @Test
    fun testMe2() {
        val res = App.echo(listOf("test1", "test2"))
        assertEquals("echo:test1", res)
    }

    @Test
    fun testDefault() {
        val res = App.echo(listOf())
        assertEquals("echo:default", res)
    }
}