package com.leo.myweather.retrofit

import com.leo.myweather.retrofit.ServiceApi.HttpConstant.HTTP_SERVER
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object ServiceApi {
    val service:CoroutineService by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
        build()
    }

    private fun build():CoroutineService{
        val retrofit=Retrofit.Builder().apply{
            baseUrl(HTTP_SERVER)
            client(OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build())
            addConverterFactory(ScalarsConverterFactory.create())//响应纯文本格式
            addConverterFactory(GsonConverterFactory.create())//响应json或xml
//            client(OkHttpClientManager.mClient)需要的时候再设置
        }.build()
        return retrofit.create(CoroutineService::class.java)
    }
//    private fun build():CoroutineService{
//        val retrofit = Retrofit.Builder().apply {
//            baseUrl(HttpConstant.HTTP_SERVER)
//            client(OkHttpClientManager.mClient)
//            addConverterFactory(ScalarsConverterFactory.create())
//            addConverterFactory(GsonConverterFactory.create())
//        }.build()
//        return  retrofit.create(CoroutineService::class.java)

    object HttpConstant{
        internal val HTTP_SERVER="http://guolin.tech/api/"
    }
}