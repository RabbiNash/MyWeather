package dev.nashe.data.api

import dev.nashe.data.models.ForecastEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface ApiService {
    suspend fun getWeatherForecast(
        @Query("q") city: String,
        @Query("cnt") count: Int,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): ForecastEntity
}