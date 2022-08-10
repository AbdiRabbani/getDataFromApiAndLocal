package com.example.pahlawannasional.api.ui.search

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pahlawannasional.api.data.UsersResponse
import com.example.pahlawannasional.api.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUserViewModel : ViewModel() {

    val listUser = MutableLiveData<UsersResponse>()

    fun searchUser(userName : String) {
        ApiConfig.getApiService().getSearchUsers(userName).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                listUser.value = response.body()
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("SEARCH USER", "onFailure: $t")
            }
        })
    }

    fun getSearchUser() : LiveData<UsersResponse> = listUser
}