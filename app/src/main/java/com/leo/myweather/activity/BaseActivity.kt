package com.leo.myweather.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <VB: ViewBinding> : AppCompatActivity() {

    protected val binding by lazy { getViewBinding() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initData()
    }

    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun getViewBinding():VB
}