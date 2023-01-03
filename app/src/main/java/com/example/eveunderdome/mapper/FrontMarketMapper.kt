package com.example.eveunderdome.mapper

import com.example.core.model.GoodBusinessModel
import com.example.core.model.MarketBusinessModel
import com.example.eveunderdome.model.Good
import com.example.eveunderdome.model.Market

object FrontMarketMapper {

    fun toFrontMarket(response: MarketBusinessModel): Market = Market(
        goodsToMarket(response.goods)
    )

    fun goodsToMarket(goodsBusinessModel: List<GoodBusinessModel>?): List<Good> {
        val response = mutableListOf<Good>()
        goodsBusinessModel?.forEach {
            response.add(
                Good(
                    it.adjustedPrice,
                    it.averagePrice,
                    it.typeId
                )
            )
        }
        return response
    }


}