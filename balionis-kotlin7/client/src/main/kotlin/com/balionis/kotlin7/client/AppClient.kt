package com.balionis.kotlin7.client

interface AppClient : AutoCloseable {
    fun run(args: List<String>)
}