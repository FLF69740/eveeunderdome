package com.example.core.repository

import com.example.core.ResultOf
import com.example.core.model.GoodBusinessModel

interface MarketRepository {
    suspend fun getGoods(): ResultOf<List<GoodBusinessModel>>
}