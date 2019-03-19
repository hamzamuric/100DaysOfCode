package com.example.weather.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.example.weather.data.repository.ForecastRepository
import com.example.weather.internal.UnitSystem
import com.example.weather.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val unitSystem = UnitSystem.METRIC // get from settings later

    val isMetric get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
