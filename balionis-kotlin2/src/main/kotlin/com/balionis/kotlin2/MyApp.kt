package com.balionis.kotlin2

import org.slf4j.LoggerFactory
import org.slf4j.Logger

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MyApp {
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(MyApp::class.java)
    }
}

fun main(args: Array<String>) {
    MyApp.LOGGER.info("main: args=${args.joinToString()}")

    SpringApplication.run(MyApp::class.java, *args)

    MyApp.LOGGER.info("main: done")
}

