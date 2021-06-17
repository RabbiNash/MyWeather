package dev.nashe.myweather.data.models

data class DayForecastView(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feelsLike: FeelsLikeView,
    val gust: Double,
    val humidity: Int,
    val pop: Int,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: TempView,
    val weather: List<WeatherView>
)