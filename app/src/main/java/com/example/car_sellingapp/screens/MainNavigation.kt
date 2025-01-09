package com.example.car_sellingapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.car_sellingapp.LoginScreen
import com.example.car_sellingapp.model.AppViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val appViewModel: AppViewModel = viewModel()
    val appUiState by appViewModel.uiState.collectAsState()
    NavHost(navController, startDestination = Routes.MainRoute.Login.route) {
        composable(route = Routes.MainRoute.Login.route) {
            LoginScreen(navController, appViewModel, appUiState)
        }
        composable(route = Routes.MainRoute.ForgotPassword.route) {
            ForgotPasswordScreen(navController, appViewModel, appUiState)
        }
        composable(route = Routes.MainRoute.SignUp.route) {
            SignUpScreen(navController, appViewModel, appUiState)
        }
        composable(route = Routes.MainRoute.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Routes.MainRoute.Profile.route) {
            ProfileScreen(navController, appViewModel, appUiState)
        }
        composable(route = Routes.MainRoute.UpdateProfile.route) {
            UpdateDetailsAboutUserScreen(navController, appViewModel, appUiState)
        }
        composable(route = Routes.MainRoute.UploadCar.route) {
            UploadCarScreen(navController, appViewModel, appUiState)
        }
    }
}
