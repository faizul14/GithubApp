package com.example.githubapp

import androidx.lifecycle.ViewModel
import com.example.githubapp.core.domain.usecase.UseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun getData() = useCase.getDataUser()
}