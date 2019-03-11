package com.example.weather.data.network.response

import com.example.weather.data.db.entity.CurrentWeatherEntry
import com.example.weather.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)