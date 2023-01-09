package com.example.githubapp.core.domain.repository

import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.core.domain.model.ModelDetailUser
import com.example.githubapp.core.domain.model.ModelRepoUser
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getDataUser(): Flow<List<ModelDataUser>>
    fun getDetailUser(username: String): Flow<ModelDetailUser>
    fun getRepoUser(username: String): Flow<List<ModelRepoUser>>
}