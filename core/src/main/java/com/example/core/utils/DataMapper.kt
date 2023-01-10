package com.example.core.utils

import com.example.core.data.remote.response.ResponseDataUserItem
import com.example.core.data.remote.response.ResponseDetailUser
import com.example.core.data.remote.response.ResponseRepoUserItem
import com.example.core.domain.model.ModelDataUser
import com.example.core.domain.model.ModelDetailUser
import com.example.core.domain.model.ModelRepoUser

object DataMapper {
    fun mapResponseDataUserToModelDataUser(input: List<ResponseDataUserItem>): List<ModelDataUser> {
        val dataUsertList = ArrayList<ModelDataUser>()
        input.map {
            val dataUser = ModelDataUser(
                avatarUrl = it.avatarUrl,
                id = it.id,
                login = it.login,
            )
            dataUsertList.add(dataUser)
        }
        return dataUsertList
    }

    fun mapResponseRepoUsetToModelRepoUser(input: List<ResponseRepoUserItem>): List<ModelRepoUser> {
        val repoUsertList = ArrayList<ModelRepoUser>()
        input.map {
            val repoList = ModelRepoUser(
                fullName = it.fullName,
                updatedAt = it.updatedAt,
                stargazersCount = it.stargazersCount,
                name = it.name,
                description = it.description,
                id = it.id
            )
            repoUsertList.add(repoList)
        }
        return repoUsertList
    }

    fun mapResponseDetailUserToModelDetailUser(input: ResponseDetailUser): ModelDetailUser {
        val dataDetailUser = ModelDetailUser(
            avatarUrl = input.avatarUrl,
            name = input.name,
            bio = input.bio,
            id = input.id,
            login = input.login
        )
        return dataDetailUser
    }

}