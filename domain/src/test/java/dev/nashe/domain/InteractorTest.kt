package dev.nashe.domain

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import dev.nashe.domain.interactors.GetForecast
import dev.nashe.domain.models.Forecast
import dev.nashe.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InteractorTest {

    private lateinit var getForecast: GetForecast

    @Mock
    private lateinit var weatherRepository: WeatherRepository

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        getForecast = GetForecast(weatherRepository)
    }

    private suspend fun stubWeatherRepositoryGetForecast(forecast : Flow<List<Forecast>>){
        whenever(getForecast(DomainDataStub.cityName)).thenReturn(forecast)
    }

    @Test
    fun `check if forecast is retrieved from repository`() = runBlockingTest{
        stubWeatherRepositoryGetForecast(flowOf(listOf(DomainDataStub.weatherForecast)))

        val forecast = getForecast(DomainDataStub.cityName).first()

        assertThat(forecast).isEqualTo(listOf(DomainDataStub.weatherForecast))
    }
}