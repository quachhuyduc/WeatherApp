package com.example.weatherapp.resporistories

import com.example.weatherapp.api.RetrofitClient
import com.example.weatherapp.utils.Constants

class WeatherRespository {
    suspend fun getCurrentWeatherByCityName(cityName:String) =
        RetrofitClient.getWeatherAPI.getCurrentWeatherByCityName(cityName,Constants.API_KEY)

    suspend fun getCurrentWeatherByLocation(lat:String,lon:String) =
        RetrofitClient.getWeatherAPI.getCurrentWeatherByLocation(lat,lon,Constants.API_KEY)
    suspend fun getCurrentWeatherByForeCast(cityName: String) =
        RetrofitClient.getWeatherAPI.getCurrentWeatherByForeCast(cityName,Constants.API_KEY)
}