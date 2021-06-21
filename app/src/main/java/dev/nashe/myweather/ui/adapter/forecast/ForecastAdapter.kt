package dev.nashe.myweather.ui.adapter.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import dev.nashe.myweather.data.models.DayForecastView
import dev.nashe.myweather.databinding.ItemForecastBinding
import dev.nashe.myweather.ui.adapter.BaseRecyclerAdapter
import dev.nashe.myweather.ui.viewholder.forecast.ForecastViewHolder

class ForecastAdapter(callback: Callback<DayForecastView>) :
    BaseRecyclerAdapter<DayForecastView, ForecastViewHolder>(callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(ItemForecastBinding.inflate(LayoutInflater.from(parent.context)))
    }
}
