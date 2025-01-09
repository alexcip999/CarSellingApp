package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val data: User? = null,
    val message: String? = null
)
