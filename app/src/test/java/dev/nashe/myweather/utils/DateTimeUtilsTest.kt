package dev.nashe.myweather.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DateTimeUtilsTest {

    @Test
    fun getFormattedDate() {
        assertThat("Sat, Jun 19, 21").isEqualTo(DateTimeUtils.getFormattedDate(1624100400))
    }
}