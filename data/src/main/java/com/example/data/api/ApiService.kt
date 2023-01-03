package com.example.data.api

import com.example.data.model.RemoteGood
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("markets/prices/")
    suspend fun getMarketPrices(): Response<List<RemoteGood>>
}