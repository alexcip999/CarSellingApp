package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class FavsParam(
val userId: Int,
val carId: Int
)