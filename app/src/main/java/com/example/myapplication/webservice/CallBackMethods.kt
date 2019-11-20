package com.example.myapplication.webservice

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface CallBackMethods<T> : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) {
        onCallBackFailure(call, t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        onCallBackResponse(call, response)
    }


     fun onCallBackFailure(call: Call<T>, t: Throwable)

    fun onCallBackResponse(call: Call<T>, response: Response<T>)

}
