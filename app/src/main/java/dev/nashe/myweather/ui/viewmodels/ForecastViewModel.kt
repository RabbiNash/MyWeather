package dev.nashe.myweather.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nashe.domain.interactors.GetForecast
import dev.nashe.myweather.data.mappers.ForecastDomainToViewMapper
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecast: GetForecast,
    private val forecastDomainToViewMapper: ForecastDomainToViewMapper
) : ViewModel(){

}