package com.korovin.currencyconverter.presentation

import com.korovin.currencyconverter.domain.model.Currency

sealed class ConverterScreenState {

    data class Content(
        val content: List<Currency>
    ) : ConverterScreenState()

    data class Error(
        val throwable: Throwable
    ) : ConverterScreenState()

    object Progress : ConverterScreenState()
}