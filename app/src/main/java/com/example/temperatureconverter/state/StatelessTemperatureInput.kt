package com.example.temperatureconverter.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.temperatureconverter.R
import com.example.temperatureconverter.utils.convertToFahrenheit

@Composable
fun StatelessTemperatureApp(modifier: Modifier = Modifier) {
    var input by remember {
        mutableStateOf("")
    }

    var output by remember {
        mutableStateOf("")
    }


    Column {
        StatelessTemperatureInput(
            input = input,
            output = output,
            onValueChange = {
                input = it
                output = convertToFahrenheit(it)
            }
        )
    }
}


@Composable
fun StatelessTemperatureInput(
    input: String,
    output: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.stateless_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = input,
            label = { Text(stringResource(R.string.enter_celsius)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange
        )
        Text(stringResource(R.string.temperature_fahrenheit, output))
    }
}



// Disini menerapkan State Hoisting
// Merubah Statefull jadi Stateless