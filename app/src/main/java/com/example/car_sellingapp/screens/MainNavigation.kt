package com.example.car_sellingapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.car_sellingapp.LoginScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.MainRoute.Login.route) {
        composable(route = Routes.MainRoute.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Routes.MainRoute.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
        composable(route = Routes.MainRoute.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(route = Routes.MainRoute.Home.route) {
            HomeScreen()
        }
    }
}
