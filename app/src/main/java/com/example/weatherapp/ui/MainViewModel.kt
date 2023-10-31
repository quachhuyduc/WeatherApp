package com.example.weatherapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.api.response.BaseResponse
import com.example.weatherapp.models.CurrentWeatherResponse
import com.example.weatherapp.resporistories.WeatherRespository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(val weatherRespository: WeatherRespository,  application: Application) :
    AndroidViewModel(application) {

        val currentWeatherrResult:MutableLiveData<BaseResponse<CurrentWeatherResponse>> =
            MutableLiveData()


        var currentWeatherResponse:CurrentWeatherResponse? = null


    val currentWeatherLocationResult:MutableLiveData<BaseResponse<CurrentWeatherResponse>> = MutableLiveData()
    val foreCastWeatherLocationResult:MutableLiveData<BaseResponse<CurrentWeatherResponse>> = MutableLiveData()

        fun getCurrentWeatherByCityName(cityName:String){
            viewModelScope.launch {
                currentWeatherrResult.postValue(BaseResponse.Loading())
                val response = weatherRespository.getCurrentWeatherByCityName(cityName);
                currentWeatherrResult.postValue(handleCurrentWeatherResponse(response))
            }

        }

    fun getCurrentWeatherByLocation(lat:String,lon:String ){
        viewModelScope.launch {
            currentWeatherLocationResult.postValue(BaseResponse.Loading())
            val response = weatherRespository.getCurrentWeatherByLocation(lat,lon)
            currentWeatherLocationResult.postValue(handleCurrentWeatherResponse(response))
        }
    }
    fun getCurrentWeatherByForeCast(cityName: String){
        viewModelScope.launch {
            foreCastWeatherLocationResult.postValue(BaseResponse.Loading())
            val response = weatherRespository.getCurrentWeatherByForeCast(cityName)
            foreCastWeatherLocationResult.postValue(handleCurrentWeatherResponse(response))
        }
    }

    private fun handleCurrentWeatherResponse(response: Response<CurrentWeatherResponse>):BaseResponse<CurrentWeatherResponse>{
        if(response.isSuccessful && response.code() == 200){
              response.body()?.let{it ->
                  currentWeatherResponse = it
                  return BaseResponse.Success(it)
              }
        }
        return BaseResponse.Error(null,response.message())
    }
}