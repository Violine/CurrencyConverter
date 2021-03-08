package com.korovin.currencyconverter.domain.repository

import com.korovin.currencyconverter.domain.model.Currency

interface CurrencyRepository {

    suspend fun get() : List<Currency>
}