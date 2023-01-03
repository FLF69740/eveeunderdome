package com.example.data.mapper

import com.example.core.model.GoodBusinessModel
import com.example.core.model.MarketBusinessModel
import com.example.data.model.RemoteGood

object MarketMapper {

    fun toGoodsBusinessModel(remoteGoods: List<RemoteGood>?): List<GoodBusinessModel> {
        val response = mutableListOf<GoodBusinessModel>()
        remoteGoods?.forEach {
            response.add(
                GoodBusinessModel(
                    it.adjustedPrice,
                    it.averagePrice,
                    it.typeId
                )
            )
        }
        return response
    }

}