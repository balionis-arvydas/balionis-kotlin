package com.balionis.kotlin5

import org.junit.Test
import org.junit.Before
import java.util.*
import kotlin.test.assertTrue

class AppTest {

    private lateinit var app: App

    @Before
    fun setUp() {
       app = App()
    }

    @Test
    fun testMe() {
        val args = arrayOf("args1")
        app.init(args.asList())
        assertTrue(true)
    }
}
