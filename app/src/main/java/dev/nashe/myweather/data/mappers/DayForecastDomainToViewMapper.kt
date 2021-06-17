package dev.nashe.myweather.data.mappers

import dev.nashe.domain.models.DayForecast
import dev.nashe.myweather.data.mappers.base.DomainToViewMapper
import dev.nashe.myweather.data.models.DayForecastView
import dev.nashe.myweather.data.models.FeelsLikeView
import dev.nashe.myweather.data.models.TempView
import javax.inject.Inject

class DayForecastDomainToViewMapper @Inject constructor(
    private val weatherDomainToViewMapper: WeatherDomainToViewMapper
) : DomainToViewMapper<DayForecast, DayForecastView> {
    override fun mapToView(domain: DayForecast): DayForecastView {
        return DayForecastView(
            clouds = domain.clouds,
            deg = domain.deg,
            dt = domain.dt,
            feelsLike = FeelsLikeView(domain.feelsLike.day,domain.feelsLike.day,domain.feelsLike.day,domain.feelsLike.day),
            gust = domain.gust,
            humidity = domain.humidity,
            pop = domain.pop,
            pressure = domain.pressure,
            rain = domain.rain,
            speed = domain.speed,
            sunrise = domain.sunrise,
            sunset = domain.sunrise,
            temp = TempView(day = domain.temp.day,domain.temp.eve,domain.temp.max,domain.temp.min,domain.temp.morn,domain.temp.night),
            weather = weatherDomainToViewMapper.mapToDomainList(domain.weather))
    }
}