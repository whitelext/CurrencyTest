package ru.whitelext.currencytest.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface CurrencyApi {
    @Headers("Content-Type: application/javascript; charset=utf-8")
    @GET(value = "daily_json.js")
    fun getCurrency(): Single<ServerResponseDefault>
}