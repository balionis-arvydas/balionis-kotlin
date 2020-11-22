package com.balionis.kotlin13.commons

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

object MoshiExtensions {
    public fun <T> Class<T>.jsonAdapter(): JsonAdapter<T> = Moshi.Builder().build().adapter(this)
            ?: throw IllegalStateException("Failed to initialize Moshi adapter for $this")
}

