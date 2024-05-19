package com.leo.myweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ViewModelUtils {
    fun provideMainViewModelFactory():MainViewModelFactory{
        return MainViewModelFactory(WeatherRepository())
    }

}

class MainViewModelFactory(
    private val repository: WeatherRepository
):ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}