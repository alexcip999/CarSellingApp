package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ParamSaveDetailsAboutUser(
    val userId: Int,
    val name: String?,
    val country: String?,
    val city: String?,
    val phone: String?,
    val profileImageUri: String? = null,
)
