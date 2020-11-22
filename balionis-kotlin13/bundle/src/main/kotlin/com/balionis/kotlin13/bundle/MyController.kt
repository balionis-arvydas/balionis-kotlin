package com.balionis.kotlin13.bundle

import mu.KotlinLogging
import org.springframework.web.bind.annotation.*

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/bundle")
class MyController {

    @GetMapping("/echo")
    fun echo(@RequestParam(required = false) name: String?) : String {
        logger.debug { "echo: name=$name" }

        val res = "Hello, ${name ?: "Engine"}!"

        logger.debug { "echo: res=$res" }

        return res
    }
}
