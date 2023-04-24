package com.example.weatherincity.feature.weather_screen.data

interface WeatherRepo {
    suspend fun getTemperature() : String
}