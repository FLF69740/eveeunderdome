package com.example.eveunderdome.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.eveunderdome.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GlobalFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_global, container, false)

        val text = view.findViewById<TextView>(R.id.title_global_fragment)

        text.text = arguments?.getInt("myNumber").toString()

        return view
    }


}