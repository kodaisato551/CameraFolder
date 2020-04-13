package com.example.camerafolder

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.weather_activity.*

class WeatherActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.weather_activity)
        setVisible(true)
        textView.setText(WeatherApi.getWeather())
    }
}