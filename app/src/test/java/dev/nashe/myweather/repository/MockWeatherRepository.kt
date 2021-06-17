package dev.nashe.myweather.repository

import dev.nashe.domain.models.Forecast
import dev.nashe.domain.repositories.WeatherRepository
import dev.nashe.myweather.data.ViewDataStub
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockWeatherRepository : WeatherRepository {
    override suspend fun getForecast(city: String): Flow<Forecast> {
        return flow {
            emit(ViewDataStub.weatherForecast)
        }
    }
}