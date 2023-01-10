package com.example.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseDataUser(

	@field:SerializedName("ResponseDataUser")
	val responseDataUser: List<ResponseDataUserItem?>? = null
)

data class ResponseDataUserItem(

	@field:SerializedName("avatar_url")
	val avatarUrl: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("login")
	val login: String? = null
)
