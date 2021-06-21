package dev.nashe.data.utils

import dev.nashe.data.models.*

internal object Datastub {

    private val dayForecast = DayForecastEntity(5,5,56, FeelsLikeEntity(4.5,5.6,6.4,5.6),
        5.0,5,45.0,5,5.0,5.0,5,5,
        TempEntity(4.5,5.6,6.7,4.2,4.5,1.2),
        listOf(WeatherEntity("test","sdsd",34,"skds")))

    val weatherForecast = ForecastEntity(
        listOf(
            dayForecast
        ))

}