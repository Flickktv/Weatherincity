package com.example.weatherincity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class WeatherActivity : AppCompatActivity() {

    private val weatherPresenter = WeatherPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val tvWeather = findViewById<TextView>(R.id.tvWeather)
        tvWeather.text = weatherPresenter.getWeather(UUID.randomUUID().toString())
    }

}