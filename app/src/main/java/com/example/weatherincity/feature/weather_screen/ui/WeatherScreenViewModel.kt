package com.example.weatherincity.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherincity.base.BaseViewModel
import com.example.weatherincity.base.Event
import com.example.weatherincity.feature.weather_screen.WeatherInteractor
import com.example.weatherincity.feature.weather_screen.ui.model.WeatherModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState = ViewState(isLoading = false, title = "Здравствуйте, погода за окном", temperature = "", speed = "")

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.onButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.onWeatherFail(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.onWeatherSucceed(temperature = it.temperature, speed = it.speed))
                        }
                    )
                }
                return previousState.copy(isLoading = true)
            }

            is DataEvent.onWeatherSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature, speed = event.speed)
            }
            else -> return null
        }
    }
}