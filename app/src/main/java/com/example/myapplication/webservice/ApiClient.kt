package com.example.myapplication.webservice

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset

/**
 * @author Tech.us
 * @class ApiClient
 * @description RetrioFit Object createion
 * @created on  6/11/2019
 * @copyright 2019 Tech.us
 * @since 1.0
 */
class ApiClient {

    companion object {
        private const val baseUrl = "https://interview-e18de.firebaseio.com"
        private var retrofit: Retrofit? = null

        fun getApi(): ApiInterface {
            return ApiClient.getInstance().create(ApiInterface::class.java)
        }

        private fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpclient()).build()
            }
            return retrofit!!
        }

        private fun getHttpclient(): OkHttpClient {
            val httpClient = OkHttpClient().newBuilder()
            httpClient.addInterceptor(LogJsonInterceptor())
            return httpClient.build()
        }

    }

   private class LogJsonInterceptor : Interceptor {
        val uTF8 = Charset.forName("UTF-8")!!
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            Log.d("ApiResponseBody", "call url==>: ${request.url()}")
            Log.d("ApiResponseBody", "call hadders==>: ${request.headers()}")
            val response = chain.proceed(request)
            val bufferedSource = response.body()?.source()
            bufferedSource?.request(Long.MAX_VALUE)
            val buffer = bufferedSource?.buffer()
            Log.d("ApiResponseBody", "call Response==> ${buffer?.clone()?.readString(uTF8).toString()}")
            return response
        }

    }
}
