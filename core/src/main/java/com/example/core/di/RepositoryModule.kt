package com.example.core.di

import com.example.core.data.ImplRepository
import com.example.core.domain.repository.IRepository
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