package com.example.car_sellingapp.data.remote

object HttpRoutes {
    const val PROFILE = "http://192.168.56.1:8080/auth/findUser"
    const val PROFILE_DETAILS = "http://192.168.56.1:8080/profile/getUserDetailsById"
    const val SAVE_DETAILS_PROFILE = "http://192.168.56.1:8080/profile/saveUserDetails"
    const val GET_USERS = "http://192.168.56.1:8080/users"
    const val LOGIN = "http://192.168.56.1:8080/auth/login"
    const val REGISTER = "http://192.168.56.1:8080/auth/register"
    const val FORGOT = "http://192.168.56.1:8080/auth/forgot-password"
    const val UPLOAD_CAR = "http://192.168.56.1:8080/cars/upload_car"
}