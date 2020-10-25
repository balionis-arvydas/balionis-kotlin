package com.balionis.kotlin7.client

import mu.KotlinLogging

import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.common.serialization.Serdes
import java.util.Properties

private val logger = KotlinLogging.logger {}

class App {
    private fun buildProperties(kafkaBrokerUri: String, clientType: String): Properties =
        Properties().apply {
            put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerUri)
            put(StreamsConfig.CLIENT_ID_CONFIG, Constants.ClientPrefix + clientType)
            put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass)
            put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass)
        }

    fun run(args: List<String>) {
        val clientType = args.getOrElse(0) { Constants.ProducerClient }
        val kafkaBrokerUri = args.getOrElse(1) { Constants.DefaultKafkaBrokerUri }
        val props = buildProperties(kafkaBrokerUri, clientType)

        val client = when(clientType) {
            Constants.ConsumerClient -> AppConsumer(props)
            else -> AppProducer(props)
        }

        client.run(args.drop(2))

    }
}

fun main(args: Array<String>) {

    logger.debug { "main: args=${args.joinToString()}" }

    App().run(args.asList())

    logger.debug { "main: done" }
}
