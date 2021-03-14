package com.balionis.kotlin15.service1.handlers

import com.natpryce.hamkrest.and
import com.natpryce.hamkrest.assertion.assertThat
import io.kotest.core.spec.style.AnnotationSpec
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.hamkrest.hasBody
import org.http4k.hamkrest.hasStatus

class EchoHandlerTest : AnnotationSpec() {
    @Test
    fun testHandler() {
        val json =
            """
            {"payload":{"args":["arg1","arg2"]}}
            """.trimIndent()

        val expected =
            """
            {"payload":{"message":"echo:arg1"}}
            """.trimIndent()

        val response = echoHandler(Request(Method.GET, "/echo").body(json))

        assertThat(response, hasStatus(OK).and(hasBody(expected)))
    }

    @Test
    fun testHandlerDefault() {
        val json =
            """
            {"payload":{"args":[]}}
            """.trimIndent()

        val expected =
            """
            {"payload":{"message":"echo:default"}}
            """.trimIndent()

        val response = echoHandler(Request(Method.GET, "/echo").body(json))

        assertThat(response, hasStatus(OK).and(hasBody(expected)))
    }
}
