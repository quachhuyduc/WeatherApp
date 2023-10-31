package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.api.response.BaseResponse
import com.example.weatherapp.models.Weather
import com.example.weatherapp.resporistories.WeatherRespository

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherRespository = WeatherRespository()
        val mainViewModelFactory  = MainViewModelFactory(weatherRespository,application)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]


     //   mainViewModel.getCurrentWeatherByCityName("Hà Nội")
      //  mainViewModel.currentWeatherrResult.observe(this, Observer { response ->
     //       when(response){
    //            is BaseResponse.Loading -> showLoading()

   //             is BaseResponse.Success ->{
    //                 hideLoading()
      //              val currentWeatherResponse = response.data
     //               Log.d("TAG", "BaseResponse.Success:  ${currentWeatherResponse?.name}")
     //           }
    //            is  BaseResponse.Error ->{
       //             hideLoading()
       //             Log.d("TAG", "BaseResponse.Error:  ${response.message}")
    //            }
    //        }
   //     })

     /*   mainViewModel.getCurrentWeatherByLocation("21.039204983876065","105.77393982502603")
        mainViewModel.currentWeatherLocationResult.observe(this, Observer { response ->
            when(response){
            is BaseResponse.Loading -> showLoading()

            is BaseResponse.Success ->{
                hideLoading()
                val currentWeatherResponse = response.data
                Log.d("TAG", "BaseResponse.Success:  ${currentWeatherResponse?.name}")
            }
            is  BaseResponse.Error ->{
                hideLoading()
                Log.d("TAG", "BaseResponse.Error:  ${response.message}")
            }
        } })

      */

        mainViewModel.getCurrentWeatherByForeCast("Hà Nội")
        mainViewModel.foreCastWeatherLocationResult.observe(this, Observer { response ->
            when(response){
                is BaseResponse.Loading -> showLoading()

                is BaseResponse.Success ->{
                    hideLoading()
                    val currentWeatherResponse = response.data
                    Log.d("TAG", "BaseResponse.Success:  ${currentWeatherResponse?.name}")
                }
                is  BaseResponse.Error ->{
                    hideLoading()
                    Log.d("TAG", "BaseResponse.Error:  ${response.message}")
                }
            }
        })


    }
    private fun showLoading(){

    }
    private fun hideLoading(){

    }


}