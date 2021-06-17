package dev.nashe.myweather.mapper

import com.google.common.truth.Truth
import dev.nashe.myweather.data.ViewDataStub
import dev.nashe.myweather.data.mappers.DayForecastDomainToViewMapper
import dev.nashe.myweather.data.mappers.ForecastDomainToViewMapper
import dev.nashe.myweather.data.mappers.WeatherDomainToViewMapper
import org.junit.Test

class DomainToViewMapperTest {
    private val weatherDomainToViewMapper = WeatherDomainToViewMapper()
    private val dayForecastDomainToViewMapper = DayForecastDomainToViewMapper(weatherDomainToViewMapper)
    private val forecastDomainToViewMapper = ForecastDomainToViewMapper(dayForecastDomainToViewMapper)

    @Test
    fun `test if forecast domain model is mapped to forecast view`(){
        val weatherForecast = ViewDataStub.weatherForecast

        val weatherForecastView = forecastDomainToViewMapper.mapToView(weatherForecast)

        Truth.assertThat(weatherForecast.forecast[0].clouds).isEqualTo(weatherForecastView.forecast[0].clouds)
        Truth.assertThat(weatherForecast.forecast[0].deg).isEqualTo(weatherForecastView.forecast[0].deg)
        Truth.assertThat(weatherForecast.forecast[0].dt).isEqualTo(weatherForecastView.forecast[0].dt)

        //lower level test
        Truth.assertThat(weatherForecast.forecast[0].weather[0].description).isEqualTo(weatherForecastView.forecast[0].weather[0].description)
        Truth.assertThat(weatherForecast.forecast[0].weather[0].description).isEqualTo(weatherForecastView.forecast[0].weather[0].description)
        Truth.assertThat(weatherForecast.forecast[0].weather[0].description).isEqualTo(weatherForecastView.forecast[0].weather[0].description)
    }
}