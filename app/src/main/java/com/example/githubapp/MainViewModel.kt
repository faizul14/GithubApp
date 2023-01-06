package com.example.githubapp

import androidx.lifecycle.ViewModel
import com.example.githubapp.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun getData() = useCase.getDataUser()
}