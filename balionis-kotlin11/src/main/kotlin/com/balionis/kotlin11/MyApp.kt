package com.balionis.kotlin11

import mu.KotlinLogging
import org.activiti.spring.boot.SecurityAutoConfiguration
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

private val logger = KotlinLogging.logger {}

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class MyApp

fun main(args: Array<String>) {
	logger.debug { "main: args=${args.joinToString()}" }

	runApplication<MyApp>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}

	logger.debug { "main:-" }
}
