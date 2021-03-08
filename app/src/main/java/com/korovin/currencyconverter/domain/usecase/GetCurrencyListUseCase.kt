package com.korovin.currencyconverter.domain.usecase

import com.korovin.currencyconverter.domain.repository.CurrencyRepository
import javax.inject.Inject

class GetCurrencyListUseCase @Inject constructor(
    private val repository: CurrencyRepository,
) {

    suspend operator fun invoke() =
        repository.get()
}