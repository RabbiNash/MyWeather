package dev.nashe.myweather.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.nashe.domain.models.DayForecast
import dev.nashe.myweather.R
import dev.nashe.myweather.data.models.DayForecastView
import dev.nashe.myweather.databinding.FragmentForecastBinding
import dev.nashe.myweather.ui.adapter.BaseRecyclerAdapter
import dev.nashe.myweather.ui.adapter.forecast.ForecastAdapter
import dev.nashe.myweather.ui.fragment.base.BaseFragment
import dev.nashe.myweather.ui.viewmodels.ForecastViewModel
import dev.nashe.myweather.utils.ItemOffsetDecoration
import dev.nashe.myweather.utils.Result
import timber.log.Timber

@AndroidEntryPoint
class ForecastFragment : BaseFragment<FragmentForecastBinding>(), BaseRecyclerAdapter.Callback<DayForecastView> {
    override val layout: Int
        get() = R.layout.fragment_forecast

    private val forecastViewModel : ForecastViewModel by viewModels()
    private val forecastAdapter = ForecastAdapter(this)
    private var selectedCity = "Paris"

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            forecastViewModel.performSearch(text.toString())
            selectedCity = binding?.etSearch?.text.toString()
        }

        override fun afterTextChanged(p0: Editable?) {}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        forecastViewModel.performSearch("Paris")
        setupForecastView()
        initForecast()

    }

    private fun initForecast(){
        forecastViewModel.searchResults.asLiveData().observe(viewLifecycleOwner, {
            when (it){
                is Result.Success -> {
                    forecastAdapter.setItems(it.data.forecast)
                    toggleLoading(false)
                    setCityView(selectedCity)
                }
                is Result.Error -> {
                    Timber.d(it.message)
                    toggleLoading(false)
                    //for additional information you display the error message
                    setCityView("City Not found")
                    forecastAdapter.clearItems()
                }
                is Result.Idle -> {
                    toggleLoading(false)
                }
                is Result.Loading -> {
                    toggleLoading(true)
                }
            }
        })
    }

    private fun setCityView(city : String?){
        binding?.apply {
            tvCity.visibility = View.VISIBLE
            tvCity.text = city
        }
    }

    private fun toggleLoading(isLoadingState : Boolean){
        binding?.apply {
            isLoading = isLoadingState
        }
    }

    private fun setupForecastView(){
        binding?.apply {
            etSearch.addTextChangedListener(textWatcher)

            rvForecast.apply {
                this.adapter = forecastAdapter
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(
                    ItemOffsetDecoration(
                        requireContext(),
                        R.dimen.padding_8
                    )
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()

        toggleLoading(false)
        binding?.tvCity?.visibility = View.GONE
    }

    override fun onItemSelected(t: DayForecastView) {
        val inputCity = binding?.etSearch?.text.toString()
        if (inputCity.isNotEmpty()) selectedCity = inputCity
        navigate(ForecastFragmentDirections.actionForecastFragmentToDayWeatherFragment(t, selectedCity))
    }

    companion object {
        val EMPTY_LIST = listOf<DayForecastView>()
    }
}