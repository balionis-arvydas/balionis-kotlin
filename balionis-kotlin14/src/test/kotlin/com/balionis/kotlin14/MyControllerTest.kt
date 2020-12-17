package com.balionis.kotlin14

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class MyControllerTest {

    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun testHelloWorldResponse() {
        val rsp: String = client.toBlocking()
                .retrieve("/echo/John")
        assertEquals("TEST: Hello from, John!", rsp)
    }
}