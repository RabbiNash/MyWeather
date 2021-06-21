package dev.nashe.myweather.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastView(
    val forecast: List<DayForecastView>,
) : Parcelable