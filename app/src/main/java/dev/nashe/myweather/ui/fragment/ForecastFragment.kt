package dev.nashe.myweather.ui.fragment

import dagger.hilt.android.AndroidEntryPoint
import dev.nashe.myweather.R
import dev.nashe.myweather.databinding.FragmentForecastBinding
import dev.nashe.myweather.ui.fragment.base.BaseFragment

@AndroidEntryPoint
class ForecastFragment : BaseFragment<FragmentForecastBinding>() {
    override val layout: Int
        get() = R.layout.fragment_forecast
}