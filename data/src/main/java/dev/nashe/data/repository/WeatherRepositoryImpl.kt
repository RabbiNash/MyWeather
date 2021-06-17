package dev.nashe.data.repository

import dev.nashe.data.api.ApiService
import dev.nashe.data.mapper.forecast.ForecastEntityToDomainMapper
import dev.nashe.data.utils.AuthUtil
import dev.nashe.data.utils.MiscUtils
import dev.nashe.domain.models.Forecast
import dev.nashe.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val forecastEntityToDomainMapper: ForecastEntityToDomainMapper
) : WeatherRepository {

    override suspend fun getForecast(city: String): Flow<Forecast> {
        return flow {
            emit(
                forecastEntityToDomainMapper.mapToDomain(
                    apiService.getWeatherForecast(
                        city,
                        MiscUtils.COUNT,
                        AuthUtil.API_KEY,
                        MiscUtils.UNITS
                    )
                )
            )
        }
    }
}