package com.balionis.kotlin1

import kotlin.test.assertEquals
import org.junit.Test

class MyServiceTest {
    @Test
    fun testOk() {
        val service = MyServiceImpl("myService")
        val actual = service.echo("myMessage")
        assertEquals("myService:myMessage", actual)
    }
}