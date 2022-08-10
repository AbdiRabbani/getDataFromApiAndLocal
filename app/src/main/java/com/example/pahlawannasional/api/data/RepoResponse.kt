package com.example.pahlawannasional.api.data

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class RepoResponse(
    @field:SerializedName("items")
    val repoResponseItem: List<RepoResponseItem>? = null
)

data class RepoResponseItem(
    @field:SerializedName("name")
    val name : String? = null,

    @field:SerializedName("full_name")
    val fullName : String? = null,

    @field:SerializedName("descripton")
    val description : String? = null,

    @field:SerializedName("topics")
    val topics : List<String>
)