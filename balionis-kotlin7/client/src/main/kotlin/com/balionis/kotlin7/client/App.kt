package com.balionis.kotlin7.client

import mu.KotlinLogging

import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.common.serialization.Serdes
import java.util.Properties

private val logger = KotlinLogging.logger {}

class App {

    fun run(args: List<String>) {
        val clientType = args.getOrElse(0) { Constants.ProducerClient }
        val brokerUri = args.getOrElse(1) { Constants.DefaultKafkaBrokerUri }

        val client = when(clientType) {
            Constants.ConsumerClient -> AppConsumer(brokerUri)
            else -> AppProducer(brokerUri)
        }

        client.run(args.drop(2))
    }
}

fun main(args: Array<String>) {

    logger.debug { "main: args=${args.joinToString()}" }

    App().run(args.asList())

    logger.debug { "main: done" }
}
