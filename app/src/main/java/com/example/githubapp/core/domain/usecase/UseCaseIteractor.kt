package com.example.githubapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.core.domain.model.ModelDetailUser
import com.example.githubapp.core.domain.model.ModelRepoUser
import com.example.githubapp.core.domain.repository.IRepository

class UseCaseIteractor(private val repository: IRepository): UseCase{
    override fun getDataUser(): LiveData<List<ModelDataUser>> {
        return repository.getDataUser()
    }

    override fun getDetailUser(username: String): LiveData<ModelDetailUser> {
        return repository.getDetailUser(username)
    }

    override fun getRepoUser(username: String): LiveData<List<ModelRepoUser>> {
        return repository.getRepoUser(username)
    }
}