package com.balionis.kotlin1

object App {
    fun echo(args: List<String>): String {
        val msg = args.getOrElse(0) { "default" }
        return "echo:${msg}"
    }
}

fun main(args: Array<String>) {
    println("main: args=${args.joinToString()}")

    val msg = App.echo(args.asList())

    println("main: msg=${msg}")

    println("main: done")
}