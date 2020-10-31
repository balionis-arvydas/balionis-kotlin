package com.balionis.kotlin8.client

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

object MoshiExtensions {
    public fun <T> Class<T>.jsonAdapter(): JsonAdapter<T> = Moshi.Builder().build().adapter(this)
            ?: throw IllegalStateException("Failed to initialize Moshi adapter for $this")
}

