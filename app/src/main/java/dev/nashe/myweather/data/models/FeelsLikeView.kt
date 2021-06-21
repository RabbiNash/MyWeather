package dev.nashe.myweather.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeelsLikeView(
    val day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
) : Parcelable