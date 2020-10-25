package com.balionis.kotlin7.client

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

object MoshiHelper {
    fun <T> Class<T>.jsonAdapter(): JsonAdapter<T> = Moshi.Builder().build().adapter(this)
            ?: throw IllegalStateException("Failed to initialize Moshi adapter for $this")
}

