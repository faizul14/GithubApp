package com.example.core.domain.usecase

import com.example.core.domain.model.ModelDataUser
import com.example.core.domain.model.ModelDetailUser
import com.example.core.domain.model.ModelRepoUser
import com.example.core.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCaseIteractor @Inject constructor(private val repository: IRepository) : UseCase {
    override fun getDataUser(): Flow<List<ModelDataUser>> {
        return repository.getDataUser()
    }

    override fun getDetailUser(username: String): Flow<ModelDetailUser> {
        return repository.getDetailUser(username)
    }

    override fun getRepoUser(username: String): Flow<List<ModelRepoUser>> {
        return repository.getRepoUser(username)
    }
}