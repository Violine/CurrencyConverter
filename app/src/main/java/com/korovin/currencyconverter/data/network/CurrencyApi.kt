package com.korovin.currencyconverter.data.network

import com.korovin.currencyconverter.data.model.ResponseModel
import retrofit2.http.GET

interface CurrencyApi {

    @GET("daily_json.js")
    suspend fun getCurrency(): ResponseModel
}