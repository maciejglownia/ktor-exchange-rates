package com.maciejglownia.routes

import com.maciejglownia.data.*
import com.maciejglownia.data.model.ExchangeRateData
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.LocalDate

const val CURRENCY_SYMBOL = "EUR"
private val currentDate: LocalDate = LocalDate.now()
private val previousDate: LocalDate = LocalDate.now().minusDays(1)
private val twoPreviousDate: LocalDate = LocalDate.now().minusDays(2)
private val threePreviousDate: LocalDate = LocalDate.now().minusDays(3)
private val fourPreviousDate: LocalDate = LocalDate.now().minusDays(4)
private val fivePreviousDate: LocalDate = LocalDate.now().minusDays(5)

private val currentDateAsString : String = currentDate.toString()
private val previousDateAsString : String = previousDate.toString()
private val twoPreviousDateAsString : String = twoPreviousDate.toString()
private val threePreviousDateAsString : String = threePreviousDate.toString()
private val fourPreviousDateAsString : String = fourPreviousDate.toString()
private val fivePreviousDateAsString : String = fivePreviousDate.toString()


val ratesForCurrentDate = ExchangeRateData(CURRENCY_SYMBOL, currentDateAsString, getRatesZero())
val ratesForPreviousDate = ExchangeRateData(CURRENCY_SYMBOL, previousDateAsString, getRatesOne())
val ratesForTwoPreviousDate = ExchangeRateData(CURRENCY_SYMBOL, twoPreviousDateAsString, getRatesTwo())
val ratesForThreePreviousDate = ExchangeRateData(CURRENCY_SYMBOL, threePreviousDateAsString, getRatesThree())
val ratesForFourPreviousDate = ExchangeRateData(CURRENCY_SYMBOL, fourPreviousDateAsString, getRatesFour())
val ratesForFivePreviousDate = ExchangeRateData(CURRENCY_SYMBOL, fivePreviousDateAsString, getRatesFive())


/**
 * Gets rates for specific date. Next parse it to JSON and respond with JSON String.
 * Needs to be called in Routing.kt -> Application.configureRouting() -> routing
 */
fun Route.exchangeRatesData() {
    get("/{data}") {
        when (call.parameters["data"]) {
            currentDateAsString -> call.respond(HttpStatusCode.OK, ratesForCurrentDate)
            previousDateAsString -> call.respond(HttpStatusCode.OK, ratesForPreviousDate)
            twoPreviousDateAsString -> call.respond(HttpStatusCode.OK, ratesForTwoPreviousDate)
            threePreviousDateAsString -> call.respond(HttpStatusCode.OK, ratesForThreePreviousDate)
            fourPreviousDateAsString -> call.respond(HttpStatusCode.OK, ratesForFourPreviousDate)
            fivePreviousDateAsString -> call.respond(HttpStatusCode.OK, ratesForFivePreviousDate)
            else -> call.respond(HttpStatusCode.NotFound,"There is no more records available!")
        }
    }
}
