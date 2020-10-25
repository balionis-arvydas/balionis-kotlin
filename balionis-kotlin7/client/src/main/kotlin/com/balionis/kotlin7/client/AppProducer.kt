package com.balionis.kotlin7.client

import mu.KotlinLogging

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.*

import com.balionis.kotlin7.client.MoshiHelper.jsonAdapter
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig

private val logger = KotlinLogging.logger {}

private val requestAdapter = MyRequest::class.java.jsonAdapter()

class AppProducer(private val brokerUri: String) : AppClient {

    private val producer = KafkaProducer<String, String>(
            Properties().apply {
                put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUri)
                put(ProducerConfig.CLIENT_ID_CONFIG, AppProducer::class.java.simpleName)
                put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Serdes.String().serializer()::class.java)
                put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Serdes.String().serializer()::class.java)
            })

    override fun run(args: List<String>) {

        val json = requestAdapter.toJson(MyRequest(MyRequestPayload(args)))

        logger.debug { "run: args=${args.joinToString()}" }

        producer.send(
            ProducerRecord( Constants.TopicIn, "my-id", json)
        )

        producer.flush()
    }

    override fun close() {
        kotlin.runCatching {
            producer.close()
        }
    }
}