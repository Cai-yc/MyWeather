package com.leo.myweather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.leo.myweather.R

class ChooseAreaFragment : Fragment() {

    private var adapter:ArrayAdapter<String>?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_item_list,container,false)
        return view
//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun queryProvinces(){

    }
}