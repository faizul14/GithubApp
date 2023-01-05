package com.example.githubapp.core.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubapp.core.data.remote.network.ApiService
import com.example.githubapp.core.data.remote.response.ResponseDataUser
import com.example.githubapp.core.data.remote.response.ResponseDetailUser
import com.example.githubapp.core.data.remote.response.ResponseRepoUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getDataUser() : LiveData<ResponseDataUser>{
        val dataUser = MutableLiveData<ResponseDataUser>()

        val client = apiService.getDataUsers()
        client.enqueue(object : Callback<ResponseDataUser>{
            override fun onResponse(
                call: Call<ResponseDataUser>,
                response: Response<ResponseDataUser>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    dataUser.value = responseBody as ResponseDataUser
                }else{
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseDataUser>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })

        return dataUser
    }


    fun getDetailUser(username: String) : LiveData<ResponseDetailUser>{
        val dataUser = MutableLiveData<ResponseDetailUser>()

        val client = apiService.getDetailUser(username)
        client.enqueue(object : Callback<ResponseDetailUser>{
            override fun onResponse(
                call: Call<ResponseDetailUser>,
                response: Response<ResponseDetailUser>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    dataUser.value = responseBody as ResponseDetailUser
                }else{
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseDetailUser>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })

        return dataUser
    }


    fun getRespoUser(username: String): LiveData<ResponseRepoUser> {
        val dataUser = MutableLiveData<ResponseRepoUser>()

        val client = apiService.getRepoUser(username)
        client.enqueue(object : Callback<ResponseRepoUser> {
            override fun onResponse(
                call: Call<ResponseRepoUser>,
                response: Response<ResponseRepoUser>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    dataUser.value = responseBody as ResponseRepoUser
                } else {
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseRepoUser>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })

        return dataUser
    }


    companion object{
        const val  TAG = "RemoteDataSource"
    }
}