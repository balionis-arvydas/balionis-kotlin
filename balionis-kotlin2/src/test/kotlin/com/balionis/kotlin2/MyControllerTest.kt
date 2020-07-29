package com.balionis.kotlin2

import kotlin.test.assertEquals
import org.junit.Test;
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(MyControllerTest::class.java)
    }

    @Test
    fun testOk() {
        val res = restTemplate.getForEntity<MyMessage>("/echo?message=myMsg", MyMessage::class.java)
        LOGGER.info("testOk: res={}", res)

        assertEquals(res.statusCode, HttpStatus.OK)

        val body = res.body ?: assertNotNull(res.body, "message is null")
        LOGGER.info("testOk: body={}", body)

        assertEquals(body.message, "myMsg")
        assertTrue(body.id > 0)
    }
}