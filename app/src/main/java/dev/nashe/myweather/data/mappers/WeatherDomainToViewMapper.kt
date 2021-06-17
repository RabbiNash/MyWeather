package dev.nashe.myweather.data.mappers

import dev.nashe.domain.models.Weather
import dev.nashe.myweather.data.mappers.base.DomainToViewMapper
import dev.nashe.myweather.data.models.WeatherView
import javax.inject.Inject

class WeatherDomainToViewMapper @Inject constructor() : DomainToViewMapper<Weather, WeatherView> {
    override fun mapToView(domain: Weather): WeatherView {
        return WeatherView(
            description = domain.description,
            icon = domain.icon,
            id = domain.id,
            main = domain.main
        )
    }
}