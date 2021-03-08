package com.korovin.currencyconverter.di

import com.korovin.currencyconverter.data.CurrencyRepositoryImpl
import com.korovin.currencyconverter.data.RemoteCurrencyDataSource
import com.korovin.currencyconverter.data.RemoteCurrencyDataSourceImpl
import com.korovin.currencyconverter.data.converter.CurrencyModelConverter
import com.korovin.currencyconverter.data.network.CurrencyApi
import com.korovin.currencyconverter.domain.repository.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CurrencyConverterModule {

    @Singleton
    @Provides
    fun provideCurrencyConverterDataSource(api: CurrencyApi): RemoteCurrencyDataSource =
        RemoteCurrencyDataSourceImpl(api)

    @Singleton
    @Provides
    fun provideCurrencyConverterRepository(
        dataSource: RemoteCurrencyDataSource,
        converter: CurrencyModelConverter,
    ): CurrencyRepository =
        CurrencyRepositoryImpl(dataSource, converter)
}