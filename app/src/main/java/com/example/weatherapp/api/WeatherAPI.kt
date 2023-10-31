package com.example.weatherapp.api

import com.example.weatherapp.models.CurrentWeatherResponse
import com.example.weatherapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET(Constants.CURRENT_WEATHER_URL)
    suspend fun getCurrentWeatherByCityName(
        @Query("q") cityName:String,
        @Query("appid") apiKey:String,
        @Query("lang") lang: String? = "en"
    ):Response<CurrentWeatherResponse>

    @GET(Constants.CURRENT_WEATHER_URL)
    suspend fun getCurrentWeatherByLocation(
        @Query("lat") latitude:String,
        @Query("lon") longitude:String,
        @Query("appid") apiKey:String,
        @Query("lang") lang: String? = "en"
    ):Response<CurrentWeatherResponse>
    @GET(Constants.CURRENT_WEATHER_URL)

    suspend fun getCurrentWeatherByForeCast(
        @Query("q") cityName:String,
        @Query("appid") apiKey:String,
        @Query("lang") lang: String? = "en"
    ):Response<CurrentWeatherResponse>

}