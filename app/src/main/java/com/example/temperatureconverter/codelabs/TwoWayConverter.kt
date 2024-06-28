package com.example.temperatureconverter.codelabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.temperatureconverter.R
import com.example.temperatureconverter.enums.Scale

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
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.two_way_converter),
            style = MaterialTheme.typography.headlineSmall
        )

        GeneralTemperatureInput(
            scale = Scale.CELSIUS,
            input = "",
            onValueChange = {

            }
        )

        GeneralTemperatureInput(
            scale = Scale.FAHRENHEIT,
            input = "",
            onValueChange = {

            }
        )
    }
}