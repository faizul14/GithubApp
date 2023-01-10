package com.example.githubapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.domain.model.ModelDataUser

object DataDummyForTest {
    fun generateDummyModelDataUser() : LiveData<List<ModelDataUser>>{
        val dataList = MutableLiveData<ArrayList<ModelDataUser>>()
//        val dataList = ArrayList<ModelDataUser>()
        for (i in 1..10){
            val data = ModelDataUser(
                avatarUrl = "https://dataDummy",
                id = i,
                login = "username $i"
            )
            dataList.value?.add(data)
        }
        return dataList as LiveData<List<ModelDataUser>>
    }
}