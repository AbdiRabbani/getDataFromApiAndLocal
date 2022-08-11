package com.example.pahlawannasional.api.ui.searchrepo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pahlawannasional.api.data.RepoResponse
import com.example.pahlawannasional.api.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepoViewModel : ViewModel(){

    val listRepo = MutableLiveData<RepoResponse>()

    fun searchRepo(repositories : String) {
        ApiConfig.getApiService().getSearchRepo(repositories).enqueue(object : Callback<RepoResponse> {
            override fun onResponse(call: Call<RepoResponse>, response: Response<RepoResponse>) {
                listRepo.value = response.body()
            }

            override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                Log.e("SEARCH REPO", "onFailure: $t")
            }

        })
    }

    fun getSerchRepo() : LiveData<RepoResponse> = listRepo
}