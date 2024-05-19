package com.leo.myweather.retrofit

import com.leo.myweather.bean.CResponse
import com.leo.myweather.bean.Weather
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.GET

interface CoroutineService {
    @GET("/weather")
    suspend fun requestWeather(
        @Field("cityid") cityId:String,
        @Field("key") key:String
    ): CResponse<Weather>
}