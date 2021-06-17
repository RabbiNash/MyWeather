package dev.nashe.data.models

data class WeatherEntity(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)