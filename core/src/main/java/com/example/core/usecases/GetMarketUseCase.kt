package com.example.core.usecases

import com.example.core.ResultOf
import com.example.core.doIfSuccess
import com.example.core.model.MarketBusinessModel
import com.example.core.repository.MarketRepository
import javax.inject.Inject

class GetMarketUseCase @Inject constructor(
    private val marketRepository: MarketRepository
) {

    suspend operator fun invoke(): ResultOf<MarketBusinessModel> {
        val goods = marketRepository.getGoods()

        goods.doIfSuccess {
            return ResultOf.Success(
                MarketBusinessModel(it)
            )
        }

        return ResultOf.Error(Exception("empty list"))
    }

}