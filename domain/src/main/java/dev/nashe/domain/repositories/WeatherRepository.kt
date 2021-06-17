package dev.nashe.domain.repositories

import dev.nashe.domain.models.Forecast
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getForecast(city : String) : Flow<Forecast>
}