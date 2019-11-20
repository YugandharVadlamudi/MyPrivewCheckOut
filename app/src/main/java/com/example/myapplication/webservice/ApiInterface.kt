package com.example.myapplication.webservice

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import com.example.myapplication.webservice.ModelClass as ModelClass1

interface ApiInterface {
    @GET("/media.json")
    fun getCourse(): Call<ResponseBody>

    @POST("https://qa.tapright.com/api/v2.0/app/appuser/notes/add")
    @FormUrlEncoded
    fun apiAddNotes(@Body jsonObject: JSONObject)

}