package dev.nashe.myweather.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayForecastView(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feelsLike: FeelsLikeView,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempView,
    val weather: List<WeatherView>
) : Parcelable