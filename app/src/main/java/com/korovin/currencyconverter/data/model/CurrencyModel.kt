package com.korovin.currencyconverter.data.model

import com.squareup.moshi.Json

data class CurrencyModel(

    @field:Json(name = "ID")
    val id: String,

    @field:Json(name = "NumCode")
    val numCode: Int,

    @field:Json(name = "CharCode")
    val charCode: String,

    @field:Json(name = "Nominal")
    val nominal: Int,

    @field:Json(name = "Name")
    val name: String,

    @field:Json(name = "Value")
    val value: Float,
)