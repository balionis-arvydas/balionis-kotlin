package com.balionis.kotlin15.service1

import mu.KotlinLogging
import org.http4k.server.Jetty
import org.http4k.server.asServer
import kotlin.system.exitProcess

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    logger.info { "main: args=${args.joinToString()}" }

    runCatching {
        App(Configuration.load()).let {
            it.start()
            Runtime.getRuntime().addShutdownHook(
                Thread {
                    logger.info { "main: closing" }
                    it.close()
                    logger.info { "main: closed" }
                }
            )
        }
    }.onFailure {
        logger.error(it) { "main: unhandled exception ${it.message}" }
        exitProcess(1)
    }
}

class App(private val config: Configuration) : AutoCloseable {

    private val server = AppHandler().asServer(Jetty(config.application.port))

    fun start() {
        server.start()
    }

    override fun close() {
        runCatching {
            server.close()
        }.onFailure {
            logger.error(it) { "close: failed to close. ${it.message}" }
        }
    }
}
