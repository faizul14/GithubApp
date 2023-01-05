package com.example.githubapp.core.data

import androidx.lifecycle.LiveData
import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.core.domain.model.ModelDetailUser
import com.example.githubapp.core.domain.model.ModelRepoUser
import com.example.githubapp.core.domain.repository.IRepository

class ImplRepository() : IRepository {
    override fun getDataUser(): LiveData<List<ModelDataUser>> {
        TODO("Not yet implemented")
    }

    override fun getDetailUser(username: String): LiveData<ModelDetailUser> {
        TODO("Not yet implemented")
    }

    override fun getRepoUser(username: String): LiveData<List<ModelRepoUser>> {
        TODO("Not yet implemented")
    }
}