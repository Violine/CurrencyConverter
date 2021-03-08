package com.korovin.currencyconverter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korovin.currencyconverter.domain.usecase.GetCurrencyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val getCurrencyUseCase: GetCurrencyListUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<ConverterScreenState>(ConverterScreenState.Progress)
    val state: LiveData<ConverterScreenState> = _state

    init {
        viewModelScope.launch {
            _state.value = try {
                ConverterScreenState.Content(getCurrencyUseCase())
            } catch (exception: Exception) {
                ConverterScreenState.Error(exception)
            }
        }
    }
}