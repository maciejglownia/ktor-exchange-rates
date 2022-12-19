package com.maciejglownia.routes

import com.maciejglownia.data.*
import com.maciejglownia.data.model.ExchangeRateData
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * @value rates20221215 is an object wit exchange rates data for a specific date.
 * When rates20221215 means it is for 18th of December 2022
 */
val rates20221220 = ExchangeRateData("EUR", "2022-12-20", getRatesFor20221220())
val rates20221219 = ExchangeRateData("EUR", "2022-12-19", getRatesFor20221219())
val rates20221218 = ExchangeRateData("EUR", "2022-12-18", getRatesFor20221218())
val rates20221217 = ExchangeRateData("EUR", "2022-12-17", getRatesFor20221217())
val rates20221216 = ExchangeRateData("EUR", "2022-12-16", getRatesFor20221216())
val rates20221215 = ExchangeRateData("EUR", "2022-12-15", getRatesFor20221214())

/**
 * Gets rates for specific date. Next parse it to JSON and respond with JSON String.
 * Needs to be called in Routing.kt -> Application.configureRouting() -> routing
 */
fun Route.exchangeRatesData() {
    get("/{data}") {
        when (call.parameters["data"]) {
            // TODO make it automatically
            "2022-12-20" -> call.respond(HttpStatusCode.OK, rates20221220)
            "2022-12-19" -> call.respond(HttpStatusCode.OK, rates20221219)
            "2022-12-18" -> call.respond(HttpStatusCode.OK, rates20221218)
            "2022-12-17" -> call.respond(HttpStatusCode.OK, rates20221217)
            "2022-12-16" -> call.respond(HttpStatusCode.OK, rates20221216)
            "2022-12-15" -> call.respond(HttpStatusCode.OK, rates20221215)
            else -> call.respond(HttpStatusCode.BadRequest)
        }
    }
}
