package com.example.githubapp.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.githubapp.core.data.remote.RemoteDataSource
import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.core.domain.model.ModelDetailUser
import com.example.githubapp.core.domain.model.ModelRepoUser
import com.example.githubapp.core.domain.repository.IRepository
import com.example.githubapp.core.utils.DataMapper
import javax.inject.Inject

class ImplRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IRepository {
    override fun getDataUser(): LiveData<List<ModelDataUser>> {
        return Transformations.map(remoteDataSource.getDataUser()) {
            DataMapper.mapResponseDataUserToModelDataUser(it)
        }
    }

    override fun getDetailUser(username: String): LiveData<ModelDetailUser> {
        return Transformations.map(remoteDataSource.getDetailUser(username)) {
            DataMapper.mapResponseDetailUserToModelDetailUser(it)
        }
    }

    override fun getRepoUser(username: String): LiveData<List<ModelRepoUser>> {
        return Transformations.map(remoteDataSource.getRespoUser(username)) {
            DataMapper.mapResponseRepoUsetToModelRepoUser(it)
        }
    }
}