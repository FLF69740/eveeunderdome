package com.example.eveunderdome.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.eveunderdome.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_menu, container, false)

        val goToGlobal = view.findViewById<TextView>(R.id.menu_fragment_end)

        goToGlobal.setOnClickListener {
            view.findNavController().navigate(R.id.action_global_globalFragment)
        }

        return view
    }
}