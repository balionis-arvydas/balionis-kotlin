package com.balionis.kotlin5

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

object App {

    fun echo(req: String): String {
        logger.debug { "echo: req=${req}" }

        return req
    }
}

fun main(args: Array<String>) {

    val req = args.joinToString()

    logger.debug { "main: req=${req}" }

    val res = App.echo(req)

    logger.debug { "main: res=${res}" }

}
