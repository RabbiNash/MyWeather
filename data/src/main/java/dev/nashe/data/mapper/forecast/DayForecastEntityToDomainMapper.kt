package dev.nashe.data.mapper.forecast

import dev.nashe.data.mapper.base.ResponseMapper
import dev.nashe.data.models.DayForecastEntity
import dev.nashe.domain.models.DayForecast
import dev.nashe.domain.models.FeelsLike
import dev.nashe.domain.models.Temp
import javax.inject.Inject

/* Entity mappers are also response mappers. The idea being to map the domain to the entity */

class DayForecastEntityToDomainMapper @Inject constructor(
    private val weatherEntityToDomainMapper: WeatherEntityToDomainMapper
) : ResponseMapper<DayForecastEntity, DayForecast> {

    override fun mapToDomain(entity: DayForecastEntity): DayForecast {
        return DayForecast(
            clouds = entity.clouds,
            deg = entity.deg,
            dt = entity.dt,
            feelsLike = FeelsLike(entity.feelsLike.day,entity.feelsLike.day,entity.feelsLike.day,entity.feelsLike.day),
            gust = entity.gust,
            humidity = entity.humidity,
            pop = entity.pop,
            pressure = entity.pressure,
            rain = entity.rain,
            speed = entity.speed,
            sunrise = entity.sunrise,
            sunset = entity.sunrise,
            temp = Temp(day = entity.temp.day,entity.temp.eve,entity.temp.max,entity.temp.min,entity.temp.morn,entity.temp.night),
            weather = weatherEntityToDomainMapper.mapToDomainList(entity.weather)
        )
    }
}