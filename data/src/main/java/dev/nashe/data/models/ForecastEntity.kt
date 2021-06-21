package dev.nashe.data.models

import com.google.gson.annotations.SerializedName

data class ForecastEntity(
    @SerializedName("list") val forecast: List<DayForecastEntity>,
)