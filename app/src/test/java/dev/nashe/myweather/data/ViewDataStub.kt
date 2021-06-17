package dev.nashe.myweather.data

import dev.nashe.domain.models.*

internal object ViewDataStub {

    private val dayForecast = DayForecast(
        5, 5, 56, FeelsLike(4.5, 5.6, 6.4, 5.6),
        5.0, 5, 45, 5, 5.0, 5.0, 5, 5,
        Temp(4.5, 5.6, 6.7, 4.2, 4.5, 1.2),
        listOf(Weather("test", "sdsd", 34, "skds"))
    )

    val weatherForecast = Forecast(
        listOf(
            dayForecast
        )
    )

}
