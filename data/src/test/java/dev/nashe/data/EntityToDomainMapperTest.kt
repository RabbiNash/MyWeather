package dev.nashe.data

import com.google.common.truth.Truth.assertThat
import dev.nashe.data.mapper.forecast.DayForecastEntityToDomainMapper
import dev.nashe.data.mapper.forecast.ForecastEntityToDomainMapper
import dev.nashe.data.mapper.forecast.WeatherEntityToDomainMapper
import dev.nashe.data.utils.Datastub
import org.junit.Test

class EntityToDomainMapperTest {

    private val weatherEntityToDomainMapper = WeatherEntityToDomainMapper()
    private val dayForecastEntityToDomainMapper = DayForecastEntityToDomainMapper(weatherEntityToDomainMapper)
    private val forecastEntityToDomainMapper = ForecastEntityToDomainMapper(dayForecastEntityToDomainMapper)

    @Test
    fun `test if forecast entity is mapped to forecast domain`(){
        val weatherForecastEntity = Datastub.weatherForecast

        val weatherForecastDomain = forecastEntityToDomainMapper.mapToDomain(weatherForecastEntity)

        assertThat(weatherForecastEntity.forecast[0].clouds).isEqualTo(weatherForecastDomain.forecast[0].clouds)
        assertThat(weatherForecastEntity.forecast[0].deg).isEqualTo(weatherForecastDomain.forecast[0].deg)
        assertThat(weatherForecastEntity.forecast[0].dt).isEqualTo(weatherForecastDomain.forecast[0].dt)

        //lower level test
        assertThat(weatherForecastEntity.forecast[0].weather[0].description).isEqualTo(weatherForecastDomain.forecast[0].weather[0].description)
        assertThat(weatherForecastEntity.forecast[0].weather[0].description).isEqualTo(weatherForecastDomain.forecast[0].weather[0].description)
        assertThat(weatherForecastEntity.forecast[0].weather[0].description).isEqualTo(weatherForecastDomain.forecast[0].weather[0].description)
    }
}