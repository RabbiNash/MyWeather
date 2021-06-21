package dev.nashe.myweather.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateTimeUtils {

    private val fullFormattedTime = SimpleDateFormat("EEE, MMM d, yy", Locale.UK)

    fun getFormattedDate(timeInMillis: Long) : String {
        return fullFormattedTime.format(Date(timeInMillis * 1000L))
    }
}
