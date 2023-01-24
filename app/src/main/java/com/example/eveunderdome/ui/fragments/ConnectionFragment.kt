package com.example.eveunderdome.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.eveunderdome.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_connection, container, false)

        val button  = view.findViewById<Button>(R.id.connection_button)

        button.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.go_to_menuFragment)
        }

        return view
    }


}