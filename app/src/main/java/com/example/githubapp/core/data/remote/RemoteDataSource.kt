package com.example.githubapp.core.data.remote

import androidx.lifecycle.LiveData
import com.example.githubapp.core.data.remote.network.ApiService
import com.example.githubapp.core.data.remote.response.ResponseDataUser

class RemoteDataSource(private val apiService: ApiService) {

    fun getDataUser() : LiveData<ResponseDataUser>{
        TODO("Not yet implemented")
    }
}