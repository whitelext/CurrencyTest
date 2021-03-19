package ru.whitelext.currencytest.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ru.whitelext.currencytest.domain.Currency

@Suppress("CAST_NEVER_SUCCEEDS")
@JsonClass(generateAdapter = true)
class ValuteResponse(
    @Json(name = "AUD")
    val aud: CurrencyResponse,
    @Json(name = "AZN")
    val azn: CurrencyResponse,
    @Json(name = "GBP")
    val gbp: CurrencyResponse,
    @Json(name = "AMD")
    val amd: CurrencyResponse,
    @Json(name = "BYN")
    val byn: CurrencyResponse,
    @Json(name = "BGN")
    val bgn: CurrencyResponse,
    @Json(name = "BRL")
    val brl: CurrencyResponse,
    @Json(name = "HUF")
    val huf: CurrencyResponse,
    @Json(name = "HKD")
    val hkd: CurrencyResponse,
    @Json(name = "DKK")
    val dkk: CurrencyResponse,
    @Json(name = "USD")
    val usd: CurrencyResponse,
    @Json(name = "EUR")
    val eur: CurrencyResponse,
    @Json(name = "INR")
    val inr: CurrencyResponse,
    @Json(name = "KZT")
    val kzt: CurrencyResponse,
    @Json(name = "CAD")
    val cad: CurrencyResponse,
    @Json(name = "KGS")
    val kgs: CurrencyResponse,
    @Json(name = "CNY")
    val cny: CurrencyResponse,
    @Json(name = "MDL")
    val mdl: CurrencyResponse,
    @Json(name = "NOK")
    val nok: CurrencyResponse,
    @Json(name = "PLN")
    val pln: CurrencyResponse,
    @Json(name = "RON")
    val ron: CurrencyResponse,
    @Json(name = "XDR")
    val xdr: CurrencyResponse,
    @Json(name = "SGD")
    val sgd: CurrencyResponse,
    @Json(name = "TJS")
    val tjs: CurrencyResponse,
    @Json(name = "TRY")
    val tryy: CurrencyResponse,
    @Json(name = "TMT")
    val tmt: CurrencyResponse,
    @Json(name = "UZS")
    val uzs: CurrencyResponse,
    @Json(name = "UAH")
    val uah: CurrencyResponse,
    @Json(name = "CZK")
    val czk: CurrencyResponse,
    @Json(name = "SEK")
    val sek: CurrencyResponse,
    @Json(name = "CHF")
    val chf: CurrencyResponse,
    @Json(name = "ZAR")
    val zar: CurrencyResponse,
    @Json(name = "KRW")
    val krw: CurrencyResponse,
    @Json(name = "JPY")
    val jpy: CurrencyResponse
) {
    fun getCurrencyList(): MutableList<Currency> {
        val list = mutableListOf<Currency>()
        list.add(aud.convertToKotlinClass())
        list.add(azn.convertToKotlinClass())
        list.add(gbp.convertToKotlinClass())
        list.add(amd.convertToKotlinClass())
        list.add(byn.convertToKotlinClass())
        list.add(bgn.convertToKotlinClass())
        list.add(brl.convertToKotlinClass())
        list.add(huf.convertToKotlinClass())
        list.add(hkd.convertToKotlinClass())
        list.add(dkk.convertToKotlinClass())
        list.add(usd.convertToKotlinClass())
        list.add(eur.convertToKotlinClass())
        list.add(inr.convertToKotlinClass())
        list.add(kzt.convertToKotlinClass())
        list.add(cad.convertToKotlinClass())
        list.add(kgs.convertToKotlinClass())
        list.add(cny.convertToKotlinClass())
        list.add(mdl.convertToKotlinClass())
        list.add(nok.convertToKotlinClass())
        list.add(pln.convertToKotlinClass())
        list.add(ron.convertToKotlinClass())
        list.add(xdr.convertToKotlinClass())
        list.add(sgd.convertToKotlinClass())
        list.add(tjs.convertToKotlinClass())
        list.add(tryy.convertToKotlinClass())
        list.add(tmt.convertToKotlinClass())
        list.add(uzs.convertToKotlinClass())
        list.add(uah.convertToKotlinClass())
        list.add(czk.convertToKotlinClass())
        list.add(sek.convertToKotlinClass())
        list.add(chf.convertToKotlinClass())
        list.add(zar.convertToKotlinClass())
        list.add(krw.convertToKotlinClass())
        list.add(jpy.convertToKotlinClass())
        return list
    }
}