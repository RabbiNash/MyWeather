package dev.nashe.myweather.ui.fragment

import dagger.hilt.android.AndroidEntryPoint
import dev.nashe.myweather.R
import dev.nashe.myweather.databinding.FragmentDayWeatherBinding
import dev.nashe.myweather.ui.fragment.base.BaseFragment

@AndroidEntryPoint
class DayWeatherFragment : BaseFragment<FragmentDayWeatherBinding>() {
    override val layout: Int
        get() = R.layout.fragment_day_weather
}