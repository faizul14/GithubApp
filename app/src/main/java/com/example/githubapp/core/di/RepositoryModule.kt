package com.example.githubapp.core.di

import com.example.githubapp.core.data.ImplRepository
import com.example.githubapp.core.domain.repository.IRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideReposiroy(implRespository: ImplRepository) : IRepository
}