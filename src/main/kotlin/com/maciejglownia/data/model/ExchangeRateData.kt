package com.maciejglownia.data.model

/**
 * Serializable - pareses content below to json and send it to network.
 */
@kotlinx.serialization.Serializable
data class ExchangeRateData(
    val base: String,
    val date: String,
    val rates: Map<String, Double>,
)