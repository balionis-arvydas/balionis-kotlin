package com.balionis.kotlin14

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

@Controller("/echo")
class HelloController {

    @Get(value = "/{name}", produces = [MediaType.TEXT_PLAIN])
    fun echo(@PathVariable name: String): String {
        logger.debug { "echo: name=$name" }

        return "Hello, ${name}!"
    }
}