package com.example.eveunderdome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.eveunderdome.model.Good
import com.example.eveunderdome.model.Market
import com.example.eveunderdome.viewmodel.MarketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val marketViewModel: MarketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textList: TextView = this.findViewById(R.id.market_list)

        marketViewModel.getMarketObservation().observe(this){
            showMarketInformation(it, textList)
        }

        marketViewModel.getMarketRemote()

    }

    private fun showMarketInformation(market: Market, textView: TextView){
        var kernite = Good(null, null, 1226)
        market.goods.forEach {
            if (it.typeId == kernite.typeId) {
                kernite.adjustedPrice = it.adjustedPrice
                kernite.averagePrice = it.averagePrice
            }
        }
        val result = "${kernite.adjustedPrice}  ${kernite.averagePrice}  ${kernite.typeId}"
        textView.text = result
    }

}