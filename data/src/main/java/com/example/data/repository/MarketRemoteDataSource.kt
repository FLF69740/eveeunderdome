package com.example.data.repository

import com.example.core.ResultOf
import com.example.core.model.GoodBusinessModel
import com.example.core.model.MarketBusinessModel

interface MarketRemoteDataSource {
    suspend fun getMarketFromApi(): ResultOf<List<GoodBusinessModel>>
}