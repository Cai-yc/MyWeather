package com.leo.myweather

import com.leo.myweather.bean.CResponse
import com.leo.myweather.bean.Weather
import com.leo.myweather.retrofit.ServiceApi

class WeatherRepository {
    suspend fun getWeather(
        area:String,
        key:String
    ):CResponse<Weather>{
        return ServiceApi.service.requestWeather(area,key)
    }
}