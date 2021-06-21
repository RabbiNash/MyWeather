package dev.nashe.data.models

import com.google.gson.annotations.SerializedName

data class DayForecastEntity(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    @SerializedName("feels_like") val feelsLike: FeelsLikeEntity,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempEntity,
    val weather: List<WeatherEntity>
)