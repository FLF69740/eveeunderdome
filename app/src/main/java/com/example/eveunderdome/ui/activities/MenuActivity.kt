package com.example.eveunderdome.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.eveunderdome.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.menuContainerView) as NavHostFragment
        val navController = navHostFragment.navController
    }
}