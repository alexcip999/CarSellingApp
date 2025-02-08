package com.example.car_sellingapp.model

data class AppUiState(
    val isLoginWrong: Boolean = false,
    val isLoginPassWrong: Boolean = false,
    val isLoginEmailWrong: Boolean = false,

    val isRegisterWrong: Boolean = false,
    val isRegisterNameWrong: Boolean = false,
    val isRegisterEmailWrong: Boolean = false,
    val isRegisterEmailInvalid: Boolean = false,
    val isRegisterPasswordsWrong: Boolean = false,

    val isVerifyWrong: Boolean = false,

    val currentErrorLogin: String = "",
    val currentErrorRegister: String = "",
    val currentErrorVerify: String = ""
)
