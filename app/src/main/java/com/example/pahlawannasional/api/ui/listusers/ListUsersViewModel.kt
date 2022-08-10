package com.example.pahlawannasional.api.ui.listusers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pahlawannasional.api.data.UsersResponseItem
import com.example.pahlawannasional.api.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUsersViewModel : ViewModel() {

    //listUsers digunakan sebagai penampung data setelah diambil dari API
    val listUsers = MutableLiveData<List<UsersResponseItem>>()

    fun getListUsers() {
        ApiConfig.getApiService().getListUsers()
            .enqueue(object : Callback<List<UsersResponseItem>> {
                override fun onResponse(
                    call: Call<List<UsersResponseItem>>,
                    //data sudah beradsa di parameter response ketika fungsi getListUsers() dipakai
                    response: Response<List<UsersResponseItem>>
                ) {
                    listUsers.postValue(response.body())
//                    listUsers.value = response.body()
                }

                override fun onFailure(call: Call<List<UsersResponseItem>>, t: Throwable) {
                    Log.e("LVMerror", "onFailure: $t")
                    getListUsers()
                }

            })
    }

    //fungsi yang bertugas menyediakan data untuk ditampilkan / observe di ui controller
    fun getResultListUsers(): LiveData<List<UsersResponseItem>> = listUsers
}