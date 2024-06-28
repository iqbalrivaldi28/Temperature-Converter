package com.example.temperatureconverter.utils

fun convertToFahrenheit (celcius: String) =
    celcius.toDoubleOrNull()?.let {
        (it * 9 / 5) + 32
    }.toString()
