package com.leo.myweather.retrofit

import com.leo.myweather.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClientManager {
    val mClient:OkHttpClient by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
        buildClient()
    }

    private fun buildClient():OkHttpClient{
        val logging= HttpLoggingInterceptor()
        logging.level=if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder().apply {
            addInterceptor(CommonInterceptor())//自定义
            addInterceptor(logging)
            followRedirects(true)
        }.build()
    }
}