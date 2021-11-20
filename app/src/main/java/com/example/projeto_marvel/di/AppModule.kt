package com.example.projeto_marvel.di

import android.provider.SyncStateContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import example.projeto_marvel.common.Constants
import example.projeto_marvel.data.datasource.MarvelDataSourceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMarvelApi(): MarvelDataSourceApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelDataSourceApi::class.java)
    }
}