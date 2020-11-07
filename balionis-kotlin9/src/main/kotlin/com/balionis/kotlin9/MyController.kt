package com.balionis.kotlin9

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MyController {

    @GetMapping("/")
    fun findAll() : List<String> = listOf<String>()

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String): String = "{ \"payload\": \"$id\" }"

}