package com.example.core.di

import com.example.core.repository.MarketRepository
import com.example.core.usecases.GetMarketUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {



    }
}