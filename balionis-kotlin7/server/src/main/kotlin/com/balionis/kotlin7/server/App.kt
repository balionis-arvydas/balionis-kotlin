package com.balionis.kotlin7.server

import mu.KotlinLogging

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.Topology
import java.time.Duration
import java.util.Timer
import java.util.Properties
import kotlin.concurrent.schedule

private fun <T> Class<T>.jsonAdapter(): JsonAdapter<T> = Moshi.Builder().build().adapter(this)
    ?: throw IllegalStateException("Failed to initialize Moshi adapter for $this")

private val logger = KotlinLogging.logger {}

private val requestAdapter = MyRequest::class.java.jsonAdapter()
private val responseAdapter = MyResponse::class.java.jsonAdapter()

private val restartTimer = Timer()

class App {
    private fun buildProperties(kafkaBrokerUri: String): Properties =
        Properties().apply {
            put(StreamsConfig.APPLICATION_ID_CONFIG, Constants.ApplicationId)
            put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokerUri)
            put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass)
            put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass)
        }

    private fun buildTopology(): Topology =
        StreamsBuilder().apply {
            this.stream<String, String>(Constants.TopicIn)
                    .mapValues { reqJson ->
                        logger.debug { "buildTopology: reqJson=$reqJson" }
                        requestAdapter.fromJson(reqJson) ?: MyRequest(MyRequestPayload(listOf("undefined")))
                    }
                    .mapValues { request ->
                        MyResponse(MyResponsePayload(
                                request.payload.args.getOrElse(0) { "undefined" }))
                    }
                    .mapValues { response ->
                        val resJson = responseAdapter.toJson(response)
                        logger.debug { "buildTopology: resJson=$resJson" }
                        resJson
                    }
                    .to(Constants.TopicOut)
        }.build()

    private fun startStream(topology: Topology, properties: Properties, retries: Int) {
        logger.debug { "startStream: retries=$retries" }

        val stream = KafkaStreams(topology, properties).apply{
            setStateListener { newState, _ ->
                if ( newState == KafkaStreams.State.ERROR && retries > 0) {
                    restartTimer.schedule(Duration.ofSeconds(retries.toLong()).toMillis()) {
                        startStream(topology, properties, retries - 1)
                    }
                    close()
                }
            }
        }
        stream.start()
    }

    fun run(args: List<String>) {
        val kafkaBrokerUri = args.getOrElse(0) { Constants.DefaultKafkaBrokerUri }
        val restarts = args.getOrElse(1) { Constants.DefaultKafkaRestarts }.toInt()
        val props = buildProperties(kafkaBrokerUri)
        val topology = buildTopology()

        startStream(topology, props, restarts)
    }
}

fun main(args: Array<String>) {

    logger.debug { "main: args=${args.joinToString()}" }

    App().run(args.asList())

    logger.debug { "main: done" }
}
