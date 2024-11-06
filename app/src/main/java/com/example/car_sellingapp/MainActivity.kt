package com.example.car_sellingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.car_sellingapp.screens.MainNavigation
import com.example.car_sellingapp.ui.theme.CarSellingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarSellingAppTheme {
                MainNavigation()
            }
        }
    }
}
