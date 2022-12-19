package com.maciejglownia.plugins

import io.ktor.server.plugins.callloging.*
import org.slf4j.event.*
import io.ktor.server.request.*
import io.ktor.server.application.*
import io.ktor.server.response.*

var countApiCalls = 0
fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        countApiCalls++
        filter { call -> call.request.path().startsWith("/") }
    }

}
