package com.example.car_sellingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.car_sellingapp.screens.HomeScreen
import com.example.car_sellingapp.screens.MainNavigation
import com.example.car_sellingapp.ui.theme.CarSellingAppTheme
import com.example.myapplication.data.remote.PostsService


class MainActivity : ComponentActivity() {

    private val service = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarSellingAppTheme {
                MainNavigation()
            }
        }
    }
}


