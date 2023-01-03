package com.example.data.repository

import com.example.core.ResultOf
import com.example.core.model.GoodBusinessModel
import com.example.core.model.MarketBusinessModel
import com.example.core.repository.MarketRepository
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val marketRemoteDataSource: MarketRemoteDataSource
): MarketRepository {

    override suspend fun getGoods(): ResultOf<List<GoodBusinessModel>> {
        return marketRemoteDataSource.getMarketFromApi()
    }

}