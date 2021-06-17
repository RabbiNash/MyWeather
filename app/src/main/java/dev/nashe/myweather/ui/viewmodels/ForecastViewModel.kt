package dev.nashe.myweather.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nashe.domain.interactors.GetForecast
import dev.nashe.myweather.data.mappers.ForecastDomainToViewMapper
import dev.nashe.myweather.data.models.ForecastView
import kotlinx.coroutines.launch
import dev.nashe.myweather.utils.Result
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecast: GetForecast,
    private val forecastDomainToViewMapper: ForecastDomainToViewMapper
) : ViewModel(){

    private val _searchResults = MutableStateFlow<Result<ForecastView>>(Result.Idle)
    val searchResults: StateFlow<Result<ForecastView>>
        get() = _searchResults

    private val searchInput = MutableStateFlow("")

    init {

        viewModelScope.launch {
            /*Debounce the input to reduce unnecessary requests to the database and to also wait
            and confirm if the user has actually put some input
             */
            searchInput.debounce(timeoutMillis = DEBOUNCE_VAL).collect {
                if (it.length != VALID_ID_LENGTH) {
                    _searchResults.value = Result.Idle
                } else {
                    getForecast(it)
                        .catch { throwable ->
                            _searchResults.value = Result.Error(throwable.message)
                        }
                        .collect { forecast ->
                            _searchResults.value =
                                Result.Success(forecastDomainToViewMapper.mapToView(forecast))
                        }
                }
            }
        }
    }

    fun performSearch(searchParam: String) {
        _searchResults.value = Result.Loading

        viewModelScope.launch {
            if (searchParam.isEmpty()) {
                _searchResults.value = Result.Idle
            } else {
                searchInput.emit(searchParam)
            }
        }
    }

    companion object {
        const val DEBOUNCE_VAL = 500L
        const val VALID_ID_LENGTH = 7
    }
}