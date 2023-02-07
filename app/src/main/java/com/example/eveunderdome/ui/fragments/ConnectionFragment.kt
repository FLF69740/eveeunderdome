package com.example.eveunderdome.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.eveunderdome.R
import com.example.eveunderdome.viewmodel.MarketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectionFragment : Fragment() {

    private val marketViewModel: MarketViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_connection, container, false)

        val button  = view.findViewById<Button>(R.id.connection_button)
        val wpButton = view.findViewById<Button>(R.id.wp_password)

        button.setOnClickListener{
            findNavController().navigate(R.id.back_to_startFragment)
        }

        wpButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_global_globalFragment, bundleOf("myNumber" to 20))
        }

        return view
    }


}