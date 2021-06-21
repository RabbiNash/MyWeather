package dev.nashe.myweather.ui.viewholder.forecast

import androidx.recyclerview.widget.RecyclerView
import dev.nashe.myweather.data.models.DayForecastView
import dev.nashe.myweather.databinding.ItemForecastBinding
import dev.nashe.myweather.ui.adapter.BaseRecyclerAdapter
import dev.nashe.myweather.ui.viewholder.BaseViewHolder

class ForecastViewHolder(binding: ItemForecastBinding) :
    BaseViewHolder<DayForecastView, ItemForecastBinding, BaseRecyclerAdapter.Callback<DayForecastView>>(
        binding
    ) {

    override fun doOnBind(item: DayForecastView, callback: BaseRecyclerAdapter.Callback<DayForecastView>?) {
        binding.forecast = item

        val rootView = binding.root
        rootView.layoutParams = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )

        if (callback != null) {
            binding.root.setOnClickListener { callback.onItemSelected(item) }
        }
    }
}