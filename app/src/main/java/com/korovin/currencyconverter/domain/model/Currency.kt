package com.korovin.currencyconverter.domain.model

data class Currency(
    val id: String,
    val currencyCode: Int,
    val nameCode: String,
    val currencyName: String,
    val amountInRub: Float,
)