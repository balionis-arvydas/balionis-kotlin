package com.balionis.kotlin10

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/api")
class MyController {

    @GetMapping("/records")
    fun findAll() : List<String> {
        logger.debug { "findAll:+" }

        return listOf<String>()
    }

    @GetMapping("/records/{id}")
    fun findOne(@PathVariable id: String): String {
        logger.debug { "findOne: id=$id" }

        val res =  "{ \"payload\": \"$id\" }"

        logger.debug { "findOne: res=$res" }
        return res
    }
}
