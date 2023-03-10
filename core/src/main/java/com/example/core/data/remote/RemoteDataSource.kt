package com.example.core.data.remote

import android.util.Log
import com.example.core.data.remote.network.ApiService
import com.example.core.data.remote.response.ResponseDataUserItem
import com.example.core.data.remote.response.ResponseDetailUser
import com.example.core.data.remote.response.ResponseRepoUserItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getDataUser(): Flow<List<ResponseDataUserItem>> {
        return flow {
            try {
                val response = apiService.getDataUsers()
                val data = response
                if (data.isNotEmpty()) {
                    emit(response)
                } else {
                    Log.d(TAG, response.toString())
                }
            } catch (e: Exception) {
                Log.d(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    fun getDetailUser(username: String): Flow<ResponseDetailUser> {
        return flow {
            try {
                val respones = apiService.getDetailUser(username)
                val data = respones
                if (data != null) {
                    emit(respones)
                } else {
                    Log.d(TAG, respones.toString())
                }
            } catch (e: Exception) {
                Log.d(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    fun getRespoUser(username: String): Flow<List<ResponseRepoUserItem>> {
        return flow {
            try {
                val response = apiService.getRepoUser(username)
                val data = response
                if (data.isNotEmpty()) {
                    emit(response)
                } else {
                    Log.d(TAG, response.toString())
                }
            } catch (e: Exception) {
                Log.d(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    companion object {
        const val TAG = "RemoteDataSource"
    }
}