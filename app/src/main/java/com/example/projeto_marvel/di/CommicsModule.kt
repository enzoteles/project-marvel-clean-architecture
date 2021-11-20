package com.example.projeto_marvel.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import example.projeto_marvel.data.repository.GetCommicsRepositoryImpl
import example.projeto_marvel.domain.repository.GetCommicsRepository

@Module
@InstallIn(ViewModelComponent::class)
interface CommicsModule {

    @Binds
    fun bindGetCommicsRepository(repository: GetCommicsRepositoryImpl): GetCommicsRepository
}