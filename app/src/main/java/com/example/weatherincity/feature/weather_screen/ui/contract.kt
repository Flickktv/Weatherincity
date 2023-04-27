package com.example.weatherincity.feature.weather_screen.ui

import com.example.weatherincity.base.Event

data class ViewState(
    val speed: String,
    val isLoading: Boolean,
    val title: String,
    val temperature: String
)

sealed class UiEvent : Event {
    object onButtonClicked: UiEvent()
}

sealed class DataEvent: Event {
    data class onWeatherSucceed(val temperature: String, val speed: String): DataEvent()
    data class onWeatherFail(val error: Throwable): DataEvent()
}