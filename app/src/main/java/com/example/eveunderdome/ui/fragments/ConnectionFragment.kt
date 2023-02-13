package com.example.eveunderdome.ui.fragments

import android.app.Activity.RESULT_OK
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.eveunderdome.R
import com.example.eveunderdome.viewmodel.MarketViewModel
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectionFragment : Fragment() {

    private val marketViewModel: MarketViewModel by viewModels()
    private lateinit var connectionButton: Button
    private lateinit var warpButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_connection, container, false)

        connectionButton = view.findViewById<Button>(R.id.connection_button)
        warpButton = view.findViewById<Button>(R.id.warp_button_id)
        val wpButton = view.findViewById<Button>(R.id.wp_password)

        checkFireBaseUser()?.let {
            changeButtonStateWhenUserConnected(button = connectionButton, warp = warpButton)
        }

        connectionButton.setOnClickListener{
            if (checkFireBaseUser() == null) {
                signInLauncher.launch(signInIntent)
            }
        }

        warpButton.setOnClickListener {
            findNavController().navigate(R.id.go_to_MenuActivity)
        }

        wpButton.setOnClickListener {
            context?.let { cont ->
                AuthUI.getInstance().signOut(cont).addOnSuccessListener { _ ->
                    Navigation.findNavController(view).navigate(R.id.action_global_globalFragment, bundleOf("myNumber" to 20))
                }
            }

        }

        return view
    }

    // button connection state

    private fun changeButtonStateWhenUserConnected(button: Button, warp: Button) {
        button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_500))
        warp.visibility = View.VISIBLE
    }

    // SIGN IN

    private val providers by lazy {
        listOf(
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
    }

    private val signInLauncher = registerForActivityResult(FirebaseAuthUIActivityResultContract()) {
        res -> this.onSignInResult(res)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK){
            val user = FirebaseAuth.getInstance().currentUser
            changeButtonStateWhenUserConnected(button = connectionButton, warp = warpButton)
        }
    }

    private fun checkFireBaseUser(): FirebaseUser? = FirebaseAuth.getInstance().currentUser

    private val signInIntent by lazy {
        AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
    }

}