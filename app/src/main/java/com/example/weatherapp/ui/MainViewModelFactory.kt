package com.example.weatherapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.resporistories.WeatherRespository

class MainViewModelFactory(private val weatherRespository:WeatherRespository,private val application: Application) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(weatherRespository, application  ) as T
    }
}