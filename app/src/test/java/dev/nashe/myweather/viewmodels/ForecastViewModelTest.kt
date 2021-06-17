package dev.nashe.myweather.viewmodels

import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.google.common.truth.Truth.assertThat
import dev.nashe.domain.interactors.GetForecast
import dev.nashe.domain.repositories.WeatherRepository
import dev.nashe.myweather.data.mappers.DayForecastDomainToViewMapper
import dev.nashe.myweather.data.mappers.ForecastDomainToViewMapper
import dev.nashe.myweather.data.mappers.WeatherDomainToViewMapper
import dev.nashe.myweather.data.models.ForecastView
import dev.nashe.myweather.repository.MockWeatherRepository
import dev.nashe.myweather.ui.viewmodels.ForecastViewModel
import dev.nashe.myweather.utils.Result
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ForecastViewModelTest {

    private lateinit var weatherRepository: WeatherRepository
    private lateinit var getForecast: GetForecast

    private lateinit var viewModel: ForecastViewModel

    private val weatherDomainToViewMapper = WeatherDomainToViewMapper()
    private val dayForecastDomainToViewMapper = DayForecastDomainToViewMapper(weatherDomainToViewMapper)
    private val forecastDomainToViewMapper = ForecastDomainToViewMapper(dayForecastDomainToViewMapper)

    @Before
    fun setup() {
        weatherRepository = MockWeatherRepository()
        getForecast = GetForecast(weatherRepository)

        viewModel = ForecastViewModel(
            getForecast, forecastDomainToViewMapper
        )
    }

    @Test
    fun searchCity_returnsForecast() {
        val observer = Observer<Result<ForecastView>> {}

        try {
            viewModel.searchResults.asLiveData().observeForever(observer)
            viewModel.performSearch("paris")

            when (val forecast = viewModel.searchResults.value) {
                is Result.Success -> {
                    assertThat(forecast.data.forecast.size).isAtLeast(1)
                }
                is Result.Idle -> {
                    assertThat(forecast).isInstanceOf(Result.Idle::class.java)
                }
                is Result.Loading -> {
                    assertThat(forecast).isInstanceOf(Result.Loading::class.java)
                }

                is Error -> {
                    assertThat(forecast).isInstanceOf(Error::class.java)
                }
            }
        } finally {
            viewModel.searchResults.asLiveData().removeObserver(observer)
        }

    }

}