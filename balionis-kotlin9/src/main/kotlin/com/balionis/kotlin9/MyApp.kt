package com.balionis.kotlin9

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyApp

fun main(args: Array<String>) {
	runApplication<MyApp>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
