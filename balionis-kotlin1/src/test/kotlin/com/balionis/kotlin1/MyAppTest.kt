package com.balionis.kotlin1

import org.junit.After
import kotlin.test.assertEquals
import org.junit.Test
import org.junit.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.junit.runner.RunWith
import org.mockito.ArgumentMatcher
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

class MyAppTest {

    @Before
    fun before() {
        LOGGER.debug("before: nothing to setup")
    }

    @After
    fun after() {
        LOGGER.debug("after: nothing to clean")
    }

    @Test
    fun testOk() {
        val serviceMock = Mockito.mock(MyService::class.java)
        Mockito.`when`(serviceMock.echo("myMessage")).thenReturn("myService:myMessage")

        val runner = MyAppRunnerImpl(serviceMock)
        runner.run(MyArgs("myService", "myMessage"))

        Mockito.verify(serviceMock, Mockito.times(1)).echo("myMessage")
    }

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(MyAppTest::class.java)
    }
}