package com.korovin.currencyconverter.data

import com.korovin.currencyconverter.data.converter.CurrencyModelConverter
import com.korovin.currencyconverter.domain.repository.CurrencyRepository
import com.korovin.currencyconverter.domain.model.Currency
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteCurrencyDataSource,
    private val converter: CurrencyModelConverter,
) : CurrencyRepository {

    override suspend fun get(): List<Currency> =
        converter.convert(remoteDataSource.get())
}
