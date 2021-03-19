package ru.whitelext.currencytest.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ServerResponseDefault(
    @Json(name = "Date")
    val date: String,
    @Json(name = "PreviousDate")
    val previousDate: String,
    @Json(name = "PreviousURL")
    val previousUrs: String,
    @Json(name = "Timestamp")
    val timestamp: String,
    @Json(name = "Valute")
    val valuteResponse: ValuteResponse
) {

}