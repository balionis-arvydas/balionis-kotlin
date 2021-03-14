package com.balionis.kotlin15.service1

import com.natpryce.hamkrest.and
import com.natpryce.hamkrest.assertion.assertThat
import io.kotest.core.spec.style.AnnotationSpec
import org.http4k.client.OkHttp
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.hamkrest.hasBody
import org.http4k.hamkrest.hasStatus

class AppTest : AnnotationSpec() {

    private val client = OkHttp()
    private val config = Configuration.load()
    private val server = App(config)

    @BeforeEach
    fun setup() {
        server.start()
    }

    @AfterEach
    fun teardown() {
        server.close()
    }

    @Test
    fun testReadiness() {
        val response = client(
            Request(Method.GET, "http://localhost:${config.application.port}/readiness")
        )
        assertThat(response, hasStatus(OK).and(hasBody("success=true")))
    }
}
