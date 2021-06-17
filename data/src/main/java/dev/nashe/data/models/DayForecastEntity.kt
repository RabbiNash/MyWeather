package dev.nashe.data.models

data class DayForecastEntity(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feelsLike: FeelsLikeEntity,
    val gust: Double,
    val humidity: Int,
    val pop: Int,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempEntity,
    val weather: List<WeatherEntity>
)