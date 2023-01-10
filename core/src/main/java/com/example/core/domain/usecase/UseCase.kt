package com.example.core.domain.usecase

import com.example.core.domain.model.ModelDataUser
import com.example.core.domain.model.ModelDetailUser
import com.example.core.domain.model.ModelRepoUser
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getDataUser(): Flow<List<ModelDataUser>>
    fun getDetailUser(username: String): Flow<ModelDetailUser>
    fun getRepoUser(username: String): Flow<List<ModelRepoUser>>
}