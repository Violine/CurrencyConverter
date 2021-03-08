package com.korovin.currencyconverter.ui.theme

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.korovin.currencyconverter.domain.model.Currency
import com.korovin.currencyconverter.presentation.ConverterScreenState
import com.korovin.currencyconverter.presentation.CurrencyConverterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CurrencyConverterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.state.observe(this, ::handleState)

        setContent {
            CurrencyConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }

    private fun handleState(state: ConverterScreenState) {
        when (state) {
            is ConverterScreenState.Content -> handleContentState(state.content)
            is ConverterScreenState.Error   -> handleErrorState(state.throwable)
            ConverterScreenState.Progress   -> handleProgressState()
        }
    }

    private fun handleProgressState() {}

    private fun handleErrorState(throwable: Throwable) {}

    private fun handleContentState(content: List<Currency>) {}
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CurrencyConverterTheme {
        Greeting("Android")
    }
}