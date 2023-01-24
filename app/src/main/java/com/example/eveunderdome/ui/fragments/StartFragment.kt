package com.example.eveunderdome.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.eveunderdome.R
import com.example.eveunderdome.model.Good
import com.example.eveunderdome.model.Market
import com.example.eveunderdome.viewmodel.MarketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : Fragment() {

    private val marketViewModel: MarketViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val textList: TextView = view.findViewById(R.id.market_list)

        marketViewModel.getMarketObservation().observe(viewLifecycleOwner){
            showMarketInformation(it, textList)
        }

        textList.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.go_to_connectionFragment)
        }

        marketViewModel.getMarketRemote()


        return view
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