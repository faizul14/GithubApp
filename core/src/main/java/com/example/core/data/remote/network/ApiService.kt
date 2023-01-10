package com.example.core.data.remote.network

import com.example.core.data.remote.response.ResponseDataUser
import com.example.core.data.remote.response.ResponseDataUserItem
import com.example.core.data.remote.response.ResponseDetailUser
import com.example.core.data.remote.response.ResponseRepoUserItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: token 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")
    @GET("users")
    suspend fun getDataUsers(): List<ResponseDataUserItem>

    @Headers("Authorization: token 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")
    @GET("users/{login}")
    suspend fun getDetailUser(
        @Path("login") login: String
    ): ResponseDetailUser

    @Headers("Authorization: token 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")
    @GET("users/{login}/repos")
    suspend fun getRepoUser(
        @Path("login") login: String
    ): List<ResponseRepoUserItem>

    @GET("search/users")
    @Headers("Authorization: token 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")
    suspend fun searchUser(
        @Query("q") login: String
    ): ResponseDataUser
}