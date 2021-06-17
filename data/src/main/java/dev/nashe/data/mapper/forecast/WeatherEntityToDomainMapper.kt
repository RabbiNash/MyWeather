package dev.nashe.data.mapper.forecast

import dev.nashe.data.mapper.base.ResponseMapper
import dev.nashe.data.models.WeatherEntity
import dev.nashe.domain.models.Weather
import javax.inject.Inject

class WeatherEntityToDomainMapper @Inject constructor() : ResponseMapper<WeatherEntity, Weather> {
    override fun mapToDomain(entity: WeatherEntity): Weather {
        return Weather(
            description = entity.description,
            icon = entity.icon,
            id = entity.id,
            main = entity.main
        )
    }
}