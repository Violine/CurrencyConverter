package com.korovin.currencyconverter.data.model

import com.squareup.moshi.Json

data class ResponseModel(
    @field:Json(name = "Valute")
    val currencyModelList: Map<String, CurrencyModel>,
)