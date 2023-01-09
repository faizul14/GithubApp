package com.example.githubapp.core.data

import com.example.githubapp.core.data.remote.RemoteDataSource
import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.core.domain.model.ModelDetailUser
import com.example.githubapp.core.domain.model.ModelRepoUser
import com.example.githubapp.core.domain.repository.IRepository
import com.example.githubapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ImplRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IRepository {
    override fun getDataUser(): Flow<List<ModelDataUser>> {
        return remoteDataSource.getDataUser().map {
            DataMapper.mapResponseDataUserToModelDataUser(it)
        }
    }

    override fun getDetailUser(username: String): Flow<ModelDetailUser> {
        return remoteDataSource.getDetailUser(username).map {
            DataMapper.mapResponseDetailUserToModelDetailUser(it)
        }
    }

    override fun getRepoUser(username: String): Flow<List<ModelRepoUser>> {
        return remoteDataSource.getRespoUser(username).map {
            DataMapper.mapResponseRepoUsetToModelRepoUser(it)
        }
    }
}