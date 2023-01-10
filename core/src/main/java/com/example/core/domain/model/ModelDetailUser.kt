package com.example.core.domain.model

import com.google.gson.annotations.SerializedName

data class ModelDetailUser(
    val avatarUrl: String? = null,
    val name: String? = null,
    val bio: String? = null,
    val id: Int? = null,
    val login: String? = null
)
