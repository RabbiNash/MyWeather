package dev.nashe.domain

import dev.nashe.domain.models.*

internal object DomainDataStub {
    val weatherForecast = Forecast(
        listOf(DayForecast(5,5,56, FeelsLike(4.5,5.6,6.4,5.6),
            5.0,5,45.0,5,5.0,5.0,5,5,
            Temp(4.5,5.6,6.7,4.2,4.5,1.2),
            listOf(Weather("test","sdsd",34,"skds")))))

    val cityName = "Paris"
}