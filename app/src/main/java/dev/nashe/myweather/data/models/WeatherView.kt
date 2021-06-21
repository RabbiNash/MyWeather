package dev.nashe.myweather.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherView(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
) : Parcelable