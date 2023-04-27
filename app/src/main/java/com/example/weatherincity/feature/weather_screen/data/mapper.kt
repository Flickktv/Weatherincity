package com.example.weatherincity.feature.weather_screen.data

import com.example.weatherincity.feature.weather_screen.data.model.WeatherRemoteModel
import com.example.weatherincity.feature.weather_screen.ui.model.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.main.temperature,
    speed = this.wind.speed
)


