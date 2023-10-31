package com.example.weatherapp.api

import com.example.weatherapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {

    companion object {
        val instances: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

           val getWeatherAPI:WeatherAPI = instances.create(WeatherAPI::class.java)
    }

}