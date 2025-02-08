package com.example.car_sellingapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import com.example.car_sellingapp.screens.MainNavigation
import com.example.car_sellingapp.ui.theme.CarSellingAppTheme
import okio.AsyncTimeout

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarSellingAppTheme {
                MainNavigation()
                //com.example.car_sellingapp.update_screens.LoginScreen()
            }
        }
    }
}


