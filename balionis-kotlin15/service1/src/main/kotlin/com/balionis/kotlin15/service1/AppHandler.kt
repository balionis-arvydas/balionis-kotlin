package com.balionis.kotlin15.service1

import com.balionis.kotlin15.service1.handlers.echoHandler
import org.http4k.cloudnative.health.Health
import org.http4k.core.Method
import org.http4k.routing.bind

object AppHandler {
    operator fun invoke() = Health(
        "/echo" bind Method.POST to echoHandler
    )
}
