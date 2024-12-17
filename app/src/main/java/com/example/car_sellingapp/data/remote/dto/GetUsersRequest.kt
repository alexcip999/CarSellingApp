package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GetUsersRequest(
    val username: String,
    val password: String
)