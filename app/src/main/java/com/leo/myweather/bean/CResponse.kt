package com.leo.myweather.bean

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class CResponse<T>(
    @SerializedName("HeWeahter")
    val data:T
)
