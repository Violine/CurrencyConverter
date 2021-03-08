package com.korovin.currencyconverter.data.converter

import com.korovin.currencyconverter.data.model.ResponseModel
import com.korovin.currencyconverter.domain.model.Currency
import javax.inject.Inject

class CurrencyModelConverter @Inject constructor() {

    fun convert(model: ResponseModel): List<Currency> =
        model.currencyModelList.values.map {
            Currency(
                id = it.id,
                currencyCode = it.numCode,
                nameCode = it.charCode,
                currencyName = it.name,
                amountInRub = it.value
            )
        }
}