package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChangePasswordRequest(
    val email: String,
    val newPassword: String,
    val passwordConfirmation: String
)
