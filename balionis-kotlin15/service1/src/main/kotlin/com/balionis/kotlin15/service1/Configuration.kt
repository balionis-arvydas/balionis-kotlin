package com.balionis.kotlin15.service1

import com.typesafe.config.ConfigFactory
import io.github.config4k.extract

data class Configuration(
    val application: ApplicationConfiguration
) {
    companion object {
        fun load() = ConfigFactory.load().extract<Configuration>()
    }
}

data class ApplicationConfiguration(
    val port: Int
)
