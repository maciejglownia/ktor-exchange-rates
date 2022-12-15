package com.maciejglownia.routes

import com.maciejglownia.data.*
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
val rates20221214 = ExchangeRateData("EUR", "2022-12-14", getRatesFor20221214())
val rates20221213 = ExchangeRateData("EUR", "2022-12-13", getRatesFor20221213())
val rates20221212 = ExchangeRateData("EUR", "2022-12-12", getRatesFor20221212())
val rates20221211 = ExchangeRateData("EUR", "2022-12-11", getRatesFor20221211())

/**
 * Gets rates for specific date. Next parse it to JSON and respond with JSON String.
 * Needs to be called in Routing.kt -> Application.configureRouting() -> routing
 */
fun Route.exchangeRatesData() {
    get("/{data}") {
        when (call.parameters["data"]) {
            "2022-12-15" -> call.respond(HttpStatusCode.OK, rates20221215)
            "2022-12-14" -> call.respond(HttpStatusCode.OK, rates20221214)
            "2022-12-13" -> call.respond(HttpStatusCode.OK, rates20221213)
            "2022-12-12" -> call.respond(HttpStatusCode.OK, rates20221212)
            "2022-12-11" -> call.respond(HttpStatusCode.OK, rates20221211)
            else -> call.respond(HttpStatusCode.BadRequest)
        }
    }
}
