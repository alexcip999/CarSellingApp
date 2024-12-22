package com.example.car_sellingapp.model

data class AppUiState(
    val currentUsername: String = "",
    val currentPassword: String = "",
    val isLoginWrong: Boolean = false
)
