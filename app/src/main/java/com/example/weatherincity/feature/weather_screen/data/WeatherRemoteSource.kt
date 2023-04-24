package com.example.weatherincity.feature.weather_screen.data

import com.example.weatherincity.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherApi) {


    //Todo add query
    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Moscow")
    }
}