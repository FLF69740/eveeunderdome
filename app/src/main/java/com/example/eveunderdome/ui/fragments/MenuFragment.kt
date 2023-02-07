package com.example.eveunderdome.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eveunderdome.R
import com.example.eveunderdome.model.Good
import com.example.eveunderdome.model.Market
import com.example.eveunderdome.viewmodel.MarketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private val marketViewModel: MarketViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_menu, container, false)

        val goToGlobal = view.findViewById<TextView>(R.id.menu_fragment_end)

        goToGlobal.setOnClickListener {
            view.findNavController().navigate(R.id.action_global_globalFragment)
        }

        marketViewModel.getUserObservation().observe(viewLifecycleOwner){
            loginVerification(it)
        }

        marketViewModel.getMarketObservation().observe(viewLifecycleOwner){
            showMarketInformation(it, goToGlobal)
        }

        marketViewModel.postLoginUser(null, null)

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

    private fun loginVerification(name: String?){
        if (name != null) {
            marketViewModel.getMarketRemote()
        } else {
            findNavController().navigate(R.id.connectionFragment)
        }
    }
}