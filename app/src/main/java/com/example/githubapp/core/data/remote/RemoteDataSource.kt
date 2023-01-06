package com.example.githubapp.core.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubapp.core.data.remote.network.ApiService
import com.example.githubapp.core.data.remote.response.ResponseDataUserItem
import com.example.githubapp.core.data.remote.response.ResponseDetailUser
import com.example.githubapp.core.data.remote.response.ResponseRepoUserItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getDataUser(): LiveData<List<ResponseDataUserItem>> {
        val dataUser = MutableLiveData<List<ResponseDataUserItem>>()
        val client = apiService.getDataUsers()
        client.enqueue(object : Callback<List<ResponseDataUserItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataUserItem>>,
                response: Response<List<ResponseDataUserItem>>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    dataUser.value = responseBody!!
                } else {
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })
        return dataUser
    }


    fun getDetailUser(username: String): LiveData<ResponseDetailUser> {
        val dataUser = MutableLiveData<ResponseDetailUser>()

        val client = apiService.getDetailUser(username)
        client.enqueue(object : Callback<ResponseDetailUser> {
            override fun onResponse(
                call: Call<ResponseDetailUser>,
                response: Response<ResponseDetailUser>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    dataUser.value = responseBody!!
                } else {
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseDetailUser>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })

        return dataUser
    }


    fun getRespoUser(username: String): LiveData<List<ResponseRepoUserItem>> {
        val dataUser = MutableLiveData<List<ResponseRepoUserItem>>()

        val client = apiService.getRepoUser(username)
        client.enqueue(object : Callback<List<ResponseRepoUserItem>> {
            override fun onResponse(
                call: Call<List<ResponseRepoUserItem>>,
                response: Response<List<ResponseRepoUserItem>>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    dataUser.value = responseBody!!
                } else {
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<List<ResponseRepoUserItem>>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })

        return dataUser
    }


    companion object {
        const val TAG = "RemoteDataSource"
    }
}