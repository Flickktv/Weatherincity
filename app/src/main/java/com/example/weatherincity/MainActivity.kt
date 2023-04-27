package com.example.weatherincity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.weatherincity.feature.weather_screen.ui.UiEvent
import com.example.weatherincity.feature.weather_screen.ui.ViewState
import com.example.weatherincity.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    private val tvHello: TextView by lazy { findViewById(R.id.tvHello) }
    private val fabWeather: FloatingActionButton by lazy { findViewById(R.id.btnMain) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }
    private val tvSpeed: TextView by lazy { findViewById(R.id.tvSpeed) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this, ::render)

        fabWeather.setOnClickListener {
            viewModel.processUiEvent(UiEvent.onButtonClicked)
        }
    }

    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        if (viewState.temperature != "") {
            tvHello.text = "${viewState.title} ${viewState.temperature} градусов цельсия"
            tvSpeed.text = "Ветер сегодня ${viewState.speed} м/c"
        }
    }

}