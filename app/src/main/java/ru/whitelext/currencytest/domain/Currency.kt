package ru.whitelext.currencytest.domain

class Currency(
    val id: String,
    val numCode: String,
    val charCode: String,
    val nominal: Int,
    val name: String,
    val value: Float,
    val previousValue: Float
)