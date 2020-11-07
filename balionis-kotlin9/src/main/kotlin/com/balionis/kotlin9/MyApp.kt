package com.balionis.kotlin9

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

@SpringBootApplication
class MyApp

fun main(args: Array<String>) {
	logger.debug { "main: args=${args.joinToString()}" }

	runApplication<MyApp>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}

	logger.debug { "main:-" }
}
