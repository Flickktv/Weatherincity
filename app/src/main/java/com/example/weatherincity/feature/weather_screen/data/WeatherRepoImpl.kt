package com.example.weatherincity.feature.weather_screen.data

import com.example.weatherincity.feature.weather_screen.ui.model.WeatherModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomain()
    }

    override suspend fun getSpeed(): WeatherModel {
        return weatherRemoteSource.getSpeed().toDomain()
    }
}