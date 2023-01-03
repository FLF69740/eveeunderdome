package com.example.data.repository

import com.example.core.ResultOf
import com.example.core.model.GoodBusinessModel
import com.example.data.api.ApiService
import com.example.data.mapper.MarketMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarketRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): MarketRemoteDataSource {

    override suspend fun getMarketFromApi(): ResultOf<List<GoodBusinessModel>> = withContext(Dispatchers.IO){
        try {
            val response = apiService.getMarketPrices()
            if (response.isSuccessful){
                return@withContext ResultOf.Success(MarketMapper.toGoodsBusinessModel(response.body()!!))
            }else {
                return@withContext ResultOf.Error(Exception(response.message()))
            }
        } catch (e: Exception){
            return@withContext ResultOf.Error(e)
        }
    }
}