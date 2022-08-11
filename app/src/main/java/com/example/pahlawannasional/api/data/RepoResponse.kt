package com.example.pahlawannasional.api.data

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class RepoResponse(
    @field:SerializedName("items")
    val item: List<RepoResponseItem>? = null
)

data class RepoResponseItem(
    @field:SerializedName("name")
    val name : String? = null,

    @field:SerializedName("full_name")
    val fullName : String? = null,

    @field:SerializedName("descripton")
    val description : String? = null,

    @field:SerializedName("owner")
    val owner : OwnerResponseItem? = null,

    @field:SerializedName("visibility")
    val visibility : String? = null
)

data class OwnerResponseItem(
    @field:SerializedName("avatar_url")
    val avatarUrl : String? = null,

    @field:SerializedName("login")
    val login : String? = null
)
