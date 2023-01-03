package com.example.data.di

import com.example.core.repository.MarketRepository
import com.example.data.api.ApiService
import com.example.data.repository.MarketRemoteDataSource
import com.example.data.repository.MarketRemoteDataSourceImpl
import com.example.data.repository.MarketRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://esi.evetech.net/latest/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient
        .Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: MarketRemoteDataSourceImpl): MarketRemoteDataSource = apiHelper

    @Provides
    @Singleton
    fun provideMarketImplementation(impl: MarketRepositoryImpl): MarketRepository = impl

}