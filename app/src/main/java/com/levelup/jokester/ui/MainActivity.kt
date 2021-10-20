package com.levelup.jokester.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.levelup.jokester.R
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.navigation_host_fragment)
        NavigationUI.setupWithNavController(menu, navController)
    }
}