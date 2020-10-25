package com.balionis.kotlin7.client

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.Serdes
import java.time.Duration
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread
import kotlinx.coroutines.*

private val logger = KotlinLogging.logger {}

class AppConsumer(private val brokerUri: String) : AppClient {

    private val stop = AtomicBoolean(false)
    private val consumer = KafkaConsumer<String, String>(
            Properties().apply {
                put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUri)
                put(ConsumerConfig.CLIENT_ID_CONFIG, AppConsumer::class.java.simpleName)
                put(ConsumerConfig.GROUP_ID_CONFIG, AppConsumer::class.java.simpleName)
                put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, Serdes.String().deserializer()::class.java)
                put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Serdes.String().deserializer()::class.java)
                put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1)
            }
    )

    override fun run(args: List<String>) {
        logger.debug { "run: args=${args.joinToString()}" }

        consumer.apply {
            subscribe(listOf(Constants.TopicOut))
            thread(isDaemon = true) {
                while (!stop.get()) {
                    poll(Duration.ofHours(1)).forEach{ record ->
                        logger.debug { "run: key=${record.key()}, value=${record.value()} " }
                    }
                }
            }
        }

        runBlocking {
            delay(60000L)
        }
    }

    override fun close() {
        stop.set(true)
        kotlin.runCatching {
            consumer.close()
        }
    }
}