package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val data: String,
    val message: String
)
