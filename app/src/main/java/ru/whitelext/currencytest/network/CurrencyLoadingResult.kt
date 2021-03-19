package ru.whitelext.currencytest.network

import ru.whitelext.currencytest.domain.Currency

class CurrencyLoadingResult(
    val success: MutableList<Currency>? = null,
    val isLoading: Boolean = true,
    val error: Int? = null
)