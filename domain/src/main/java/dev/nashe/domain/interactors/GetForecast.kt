package dev.nashe.domain.interactors

import dev.nashe.domain.interactors.base.FlowUseCase
import dev.nashe.domain.models.Forecast
import dev.nashe.domain.repositories.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetForecast @Inject constructor(
    private val weatherRepository: WeatherRepository
) : FlowUseCase<List<Forecast>, String>() {

    override suspend fun invoke(params: String?): Flow<List<Forecast>> {
        if (params == null) throw IllegalArgumentException("Search parameter cannot be null")
        return weatherRepository.getForecast(params).flowOn(Dispatchers.IO)
    }
}