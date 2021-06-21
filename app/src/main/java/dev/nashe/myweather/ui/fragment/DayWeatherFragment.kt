package dev.nashe.myweather.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import dev.nashe.myweather.R
import dev.nashe.myweather.databinding.FragmentDayWeatherBinding
import dev.nashe.myweather.ui.fragment.base.BaseFragment

@AndroidEntryPoint
class DayWeatherFragment : BaseFragment<FragmentDayWeatherBinding>() {
    override val layout: Int
        get() = R.layout.fragment_day_weather

    private val args : DayWeatherFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            dayForecast = args.dayForecast
            topAppBar.title = args.city
            topAppBar.setNavigationOnClickListener { activity?.onBackPressed() }

            //check if day temperature is high or not
            tvTempStatus.text = if(args.dayForecast.temp.day > 25){
                getString(R.string.title_hot)
            } else getString(R.string.title_cold)
        }
    }
}