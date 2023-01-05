package com.example.githubapp.core.data.remote.network

import com.example.githubapp.core.data.remote.response.ResponseDataUser
import com.example.githubapp.core.data.remote.response.ResponseDetailUser
import com.example.githubapp.core.data.remote.response.ResponseRepoUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization token 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")
    @GET("users")
    fun getDataUsers(): Call<ResponseDataUser>

    @Headers("Authorization token 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")
    @GET("users/{login}")
    fun getDetailUser(
        @Path("login") login: String
    ): Call<ResponseDetailUser>

    @Headers("Authorization token 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")
    @GET("users/{login}/repos")
    fun getRepoUser(
        @Path("login") login: String
    ): Call<ResponseRepoUser>

    @GET("search/users")
    @Headers("Authorization token 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")
    fun searchUser(
        @Query("q") login: String
    ): Call<ResponseDataUser>


}