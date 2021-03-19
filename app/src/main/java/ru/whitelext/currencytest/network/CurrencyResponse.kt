package ru.whitelext.currencytest.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ru.whitelext.currencytest.domain.Currency

@JsonClass(generateAdapter = true)
data class CurrencyResponse(
    @Json(name = "ID")
    val id: String,
    @Json(name = "NumCode")
    val numCode: String,
    @Json(name = "CharCode")
    val charCode: String,
    @Json(name = "Nominal")
    val nominal: Int,
    @Json(name = "Name")
    val name: String,
    @Json(name = "Value")
    val value: Float,
    @Json(name = "Previous")
    val previousValue: Float
) {
    fun convertToKotlinClass(): Currency {
        return Currency(id, numCode, charCode, nominal, name, value, previousValue)
    }
}