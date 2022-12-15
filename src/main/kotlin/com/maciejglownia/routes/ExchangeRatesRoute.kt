package com.maciejglownia.routes

import com.maciejglownia.data.getRatesFor20221215
import com.maciejglownia.data.model.ExchangeRateData
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * @value rates20221215 is an object wit exchange rates data for a specific date.
 * When rates20221215 means it is for 15th of December 2022
 */
val rates20221215 = ExchangeRateData("EUR", "2022-12-15", getRatesFor20221215())

/**
 * Gets rates for specific date. Next parse it to JSON and respond with JSON String.
 * Needs to be called in Routing.kt -> Application.configureRouting() -> routing
 */
fun Route.exchangeRatesData() {
    get("/{2022-12-15}") {
        call.respond(
            HttpStatusCode.OK,
            rates20221215
        )
    }
}