package com.korovin.currencyconverter.data

import com.korovin.currencyconverter.data.model.ResponseModel
import com.korovin.currencyconverter.data.network.CurrencyApi
import javax.inject.Inject

interface RemoteCurrencyDataSource {

    suspend fun get(): ResponseModel
}

class RemoteCurrencyDataSourceImpl @Inject constructor(
    private val api: CurrencyApi,
) : RemoteCurrencyDataSource {

    override suspend fun get(): ResponseModel = api.getCurrency()
}