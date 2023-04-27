package com.example.weatherincity.feature.weather_screen

import com.example.weatherincity.base.Either
import com.example.weatherincity.base.attempt
import com.example.weatherincity.feature.weather_screen.data.WeatherRepo
import com.example.weatherincity.feature.weather_screen.ui.model.WeatherModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt {
            weatherRepo.getTemperature()
            weatherRepo.getSpeed()
        }
    }
}