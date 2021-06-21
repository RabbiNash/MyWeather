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
import java.lang.IllegalArgumentException

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

    private suspend fun stubWeatherRepositoryGetForecast(forecast : Flow<Forecast>){
        whenever(getForecast(DomainDataStub.cityName)).thenReturn(forecast)
    }

//    @Test
//    fun `check if forecast is retrieved from repository`() = runBlockingTest{
//        stubWeatherRepositoryGetForecast(flowOf(DomainDataStub.weatherForecast))
//
//        val forecast = getForecast(DomainDataStub.cityName).toList()
//
//        assertThat(forecast).isEqualTo(listOf(DomainDataStub.weatherForecast))
//    }

    @Test(expected = IllegalArgumentException::class)
    fun `check if illegal argument exception is raised if search param is null`() = runBlockingTest {
        getForecast().first()
    }
}