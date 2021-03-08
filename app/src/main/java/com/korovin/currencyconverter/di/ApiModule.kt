package com.korovin.currencyconverter.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.korovin.currencyconverter.BuildConfig
import com.korovin.currencyconverter.data.network.CurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    fun provideApiUrl() =
        BuildConfig.apiUrl

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            HttpLoggingInterceptor().level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        } else {
            OkHttpClient.Builder().build()
        }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(baseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi =
        retrofit.create()
}