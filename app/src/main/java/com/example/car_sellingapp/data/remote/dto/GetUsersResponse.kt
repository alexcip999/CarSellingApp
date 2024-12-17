package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GetUsersResponse(
    val id: Int,
    val username: String,
    val password: String,
    val authToken: String?
)
