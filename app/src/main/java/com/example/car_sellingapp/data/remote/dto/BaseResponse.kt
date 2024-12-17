package com.example.car_sellingapp.data.remote.dto


import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(
    val data: String? = null,
    val message: String? = null
)