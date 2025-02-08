package com.example.car_sellingapp.screens

import androidx.navigation.NavController

sealed class Routes(
    val route: String,
) {
    data object MainRoute : Routes("mainRoutes") {
        data object Login : Routes("${MainRoute.route}/login") {
            fun NavController.toLogin() = navigate("${MainRoute.route}/login")
        }

        data object ForgotPassword : Routes("${MainRoute.route}/forgotPassword") {
            fun NavController.toForgotPassword() = navigate("${MainRoute.route}/forgotPassword")
        }

        data object SignUp : Routes("${MainRoute.route}/signUp") {
            fun NavController.toSignUp() = navigate("${MainRoute.route}/signUp")
        }

        data object Home : Routes("${MainRoute.route}/home") {
            fun NavController.toHome() = navigate("${MainRoute.route}/home")
        }

        data object Profile : Routes("${MainRoute.route}/profile") {
            fun NavController.toProfile() = navigate("${MainRoute.route}/profile")
        }

        data object UpdateProfile : Routes("${MainRoute.route}/updateProfile") {
            fun NavController.toUpdateProfile() = navigate("${MainRoute.route}/updateProfile")
        }

        data object UploadCar : Routes("${MainRoute.route}/uploadCar") {
            fun NavController.toUploadCar() = navigate("${MainRoute.route}/uploadCar")
        }

        data object CarDetails : Routes("${MainRoute.route}/carDetails") {
            fun NavController.toCarDetails() = navigate("${MainRoute.route}/carDetails")
        }

        data object FavoriteCars : Routes("${MainRoute.route}/favoriteCars") {
            fun NavController.toFavorite() = navigate("${MainRoute.route}/favoriteCars")
        }

        data object YourPosts : Routes("${MainRoute.route}/yourPosts") {
            fun NavController.toYourPosts() = navigate("${MainRoute.route}/yourPosts")
        }

        data object SearchCars : Routes("${MainRoute.route}/searchCars") {
            fun NavController.toSearchCars() = navigate("${MainRoute.route}/searchCars")
        }

        data object Verify : Routes("${MainRoute.route}/verify"){
            fun NavController.toVerify() = navigate("${MainRoute.route}/verify")
        }

        data object PopUpChgPass : Routes("${MainRoute.route}/chgPass"){
            fun NavController.toChgPass() = navigate("${MainRoute.route}/chgPass")
        }

        data object PopUpRegister : Routes("${MainRoute.route}/popUpRegister"){
            fun NavController.toPopUpRegister() = navigate("${MainRoute.route}/popUpRegister")
        }
    }
}
