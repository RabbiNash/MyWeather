package dev.nashe.data.mapper.forecast

import dev.nashe.data.mapper.base.ResponseMapper
import dev.nashe.data.models.ForecastEntity
import dev.nashe.domain.models.Forecast
import javax.inject.Inject

class ForecastEntityToDomainMapper @Inject constructor(
    private val dayForecastEntityToDomainMapper: DayForecastEntityToDomainMapper
) : ResponseMapper<ForecastEntity, Forecast> {
    override fun mapToDomain(entity: ForecastEntity): Forecast {
        return Forecast(
            dayForecastEntityToDomainMapper.mapToDomainList(entity.forecast)
        )
    }
}