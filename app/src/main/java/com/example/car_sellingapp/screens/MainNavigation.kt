package com.example.car_sellingapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.car_sellingapp.model.AppViewModel
import com.example.car_sellingapp.update_screens.ChangePasswordScreen
import com.example.car_sellingapp.update_screens.LoginScreen
import com.example.car_sellingapp.update_screens.PopUpChgPass
import com.example.car_sellingapp.update_screens.PopUpChgRegister
import com.example.car_sellingapp.update_screens.RegisterScreen
import com.example.car_sellingapp.update_screens.VerifyScreen

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
            ChangePasswordScreen(navController)
        }
        composable(route = Routes.MainRoute.SignUp.route) {
            RegisterScreen(navController, appViewModel, appUiState)
        }
        composable(route = Routes.MainRoute.Verify.route){
            VerifyScreen(navController, appViewModel, appUiState)
        }
        composable(route = Routes.MainRoute.PopUpChgPass.route){
            PopUpChgPass(navController)
        }
        composable(route = Routes.MainRoute.PopUpRegister.route){
            PopUpChgRegister(navController)
        }
        composable(route = Routes.MainRoute.Home.route) {
            HomeScreen()
        }

    }
}
