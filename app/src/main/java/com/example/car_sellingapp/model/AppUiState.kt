package com.example.car_sellingapp.model

import com.example.car_sellingapp.data.remote.dto.GetUserDetailsResponse
import com.example.car_sellingapp.data.remote.dto.User

data class AppUiState(
    val isLoginWrong: Boolean = false,
    val isRegisterWrong: Boolean = false,
    val isForgotPasswordWrong: Boolean = false,
    val isUpdateWrong: Boolean = false,
    val isUploadCarWrong: Boolean = false,

    val currentUser: User? = null,

    val profileDetails: GetUserDetailsResponse? = null
)
