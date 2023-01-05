package com.example.githubapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.core.domain.model.ModelDetailUser
import com.example.githubapp.core.domain.model.ModelRepoUser

interface UseCase {
    fun getDataUser() : LiveData<List<ModelDataUser>>
    fun getDetailUser(username: String) : LiveData<ModelDetailUser>
    fun getRepoUser(username: String) : LiveData<List<ModelRepoUser>>
}