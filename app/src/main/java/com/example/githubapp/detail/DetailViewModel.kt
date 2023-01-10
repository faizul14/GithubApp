package com.example.githubapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun getDetailUser(username: String) = useCase.getDetailUser(username).asLiveData()
    fun getRepoUser(username: String) = useCase.getRepoUser(username).asLiveData()
}