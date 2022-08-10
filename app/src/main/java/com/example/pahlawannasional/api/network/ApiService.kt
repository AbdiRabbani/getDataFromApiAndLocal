package com.example.pahlawannasional.api.network

import com.example.pahlawannasional.api.data.RepoResponse
import com.example.pahlawannasional.api.data.UsersResponse
import com.example.pahlawannasional.api.data.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getListUsers(): Call<List<UsersResponseItem>>

    @GET("search/users")
    fun getSearchUsers( @Query("q") UserName: String ): Call<UsersResponse>

    @GET("search/repositories")
    fun getSearchRepo( @Query("q") RepoName: String) : Call<RepoResponse>
}