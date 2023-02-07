package com.example.eveunderdome.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ResultOf
import com.example.core.interactor.MarketInteractor
import com.example.eveunderdome.mapper.FrontMarketMapper
import com.example.eveunderdome.model.Market
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.*

@HiltViewModel
class MarketViewModel @Inject constructor(
    private val marketInteractor: MarketInteractor
): ViewModel() {

    private val getMarket by lazy { marketInteractor.marketUseCase }

    /*
     *  REMOTE
     */

    private val market = MutableLiveData<Market>()

    /*
     *  DATA
     */

    private val user = MutableLiveData<String?>()

    /*
     *  LIVEDATA GETTER
     */

    fun getMarketObservation(): MutableLiveData<Market> = market
    fun getUserObservation(): MutableLiveData<String?> = user

    /*
     *  REMOTE RESPONSE
     */

    fun getMarketRemote(){
        viewModelScope.launch {
            when(val result = getMarket.invoke()){
                is ResultOf.Success -> market.postValue(FrontMarketMapper.toFrontMarket(result.data))
                is ResultOf.Error -> Log.i("TAGO", "no remote values")
            }
        }
    }

    fun postLoginUser(name: String?, password: String?) {
        viewModelScope.launch {
            user.postValue(name)
        }
    }


}