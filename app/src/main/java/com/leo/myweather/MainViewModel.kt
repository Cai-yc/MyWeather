package com.leo.myweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leo.myweather.bean.Weather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: WeatherRepository):ViewModel() {
    private val _weather:MutableLiveData<Weather?> = MutableLiveData()
    val mWeather:LiveData<Weather?> = _weather
    fun getWeather(area:String,key:String){
        viewModelScope.launch{
            val result=repository.getWeather(area,key)
            _weather.postValue(result.data)
        }
    }
}

// 定义 requestMain 函数
fun CoroutineScope.requestMain(block: suspend () -> Unit) {
    launch(Dispatchers.Main) {
        block()
    }
}