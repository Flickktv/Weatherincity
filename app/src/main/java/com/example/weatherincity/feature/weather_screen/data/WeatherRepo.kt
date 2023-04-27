package com.example.weatherincity.feature.weather_screen.data

import com.example.weatherincity.feature.weather_screen.ui.model.WeatherModel

interface WeatherRepo {
    suspend fun getTemperature() : WeatherModel
    suspend fun getSpeed() : WeatherModel
}