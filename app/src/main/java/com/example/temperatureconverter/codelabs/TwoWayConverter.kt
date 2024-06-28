package com.example.temperatureconverter.codelabs

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
import com.example.temperatureconverter.enums.Scale
import com.example.temperatureconverter.utils.convertToCelsius
import com.example.temperatureconverter.utils.convertToFahrenheit

@Composable
fun GeneralTemperatureInput(
    scale: Scale,
    input: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        OutlinedTextField(
            value = input,
            label = { Text(stringResource(R.string.enter_temperature, scale.scaleName))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange
        )
    }
}


@Composable
fun TwoWayConverterApp(modifier: Modifier = Modifier) {

    var celcius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.two_way_converter),
            style = MaterialTheme.typography.headlineSmall
        )

        GeneralTemperatureInput(
            scale = Scale.CELSIUS,
            input = celcius,
            onValueChange = {
                celcius = it
                fahrenheit = convertToFahrenheit(it)
            }
        )

        GeneralTemperatureInput(
            scale = Scale.FAHRENHEIT,
            input = fahrenheit,
            onValueChange = {
                    fahrenheit = it
                    celcius = convertToCelsius(it)
            }
        )
    }
}