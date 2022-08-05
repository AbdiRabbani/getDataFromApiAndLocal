package com.example.pahlawannasional.api.network

import com.example.pahlawannasional.api.data.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getListUsers() : Call<List<UsersResponseItem>>
}