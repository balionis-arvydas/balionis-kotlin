package com.balionis.kotlin14

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.balionis.kotlin14")
		.start()
}

