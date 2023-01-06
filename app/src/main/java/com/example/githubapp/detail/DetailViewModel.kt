package com.example.githubapp.detail

import androidx.lifecycle.ViewModel
import com.example.githubapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    fun getDetailUser(username: String) = useCase.getDetailUser(username)
}