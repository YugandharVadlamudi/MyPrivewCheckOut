package com.example.viewmodelexample

import android.util.Log
import androidx.lifecycle.ViewModel

data class Data(var name: String)

//it is used to hold data even while changing the rotation of the activity

class ViewModelexample : ViewModel() {
    private val TAG: String? = ViewModelexample::class.java.simpleName
    private var listst = arrayListOf<Data>()

    init {
        Log.e(TAG, ": Logo")
    }

    fun getList(): ArrayList<Data> {
        if (listst.isEmpty()) {
            for (i in 0..3) {
                listst.add(Data(i.toString()))
            }
            Log.e(TAG, ":new list0 ")
            return listst
        }
        Log.e(TAG, ":old list ")
        return listst
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, ":cancel is called ")
    }
}