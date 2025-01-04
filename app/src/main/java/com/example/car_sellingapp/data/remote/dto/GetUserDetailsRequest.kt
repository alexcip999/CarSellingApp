package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GetUserDetailsRequest(
    val userId: Int
)
