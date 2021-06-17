package dev.nashe.myweather.data.mappers

import dev.nashe.domain.models.Forecast
import dev.nashe.myweather.data.mappers.base.DomainToViewMapper
import dev.nashe.myweather.data.models.ForecastView
import javax.inject.Inject

class ForecastDomainToViewMapper @Inject constructor(
    private val dayForecastDomainToViewMapper: DayForecastDomainToViewMapper
) : DomainToViewMapper<Forecast, ForecastView> {
    override fun mapToView(domain: Forecast): ForecastView {
        return ForecastView(dayForecastDomainToViewMapper.mapToViewList(domain.forecast))
    }
}