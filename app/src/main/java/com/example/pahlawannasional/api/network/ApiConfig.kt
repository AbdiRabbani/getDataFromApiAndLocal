package com.example.pahlawannasional.api.network

import com.example.pahlawannasional.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Time
import java.util.*
import java.util.concurrent.TimeUnit

object ApiConfig {

    fun getApiService() : ApiService {
        val okHttpClient = OkHttpClient().newBuilder()
            .readTimeout(30, TimeUnit.SECONDS)
            .pingInterval(10, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor{
               val request = it.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()

                return@addInterceptor it.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}