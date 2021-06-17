package dev.nashe.myweather.data.models

data class WeatherView(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)