package com.example.core.interactor

import com.example.core.usecases.GetMarketUseCase
import javax.inject.Inject

data class MarketInteractor @Inject constructor(
    val marketUseCase: GetMarketUseCase
)
