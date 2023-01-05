package com.example.githubapp.core.domain.model

import com.google.gson.annotations.SerializedName

data class ModelRepoUser(
    val fullName: String? = null,
    val updatedAt: String? = null,
    val stargazersCount: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val id: Int? = null
)

