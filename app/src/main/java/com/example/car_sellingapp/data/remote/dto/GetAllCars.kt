package com.example.car_sellingapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GetAllCars(
    val idUser: Int,
    val year: String,
    val km: String,
    val combustible: CombustibleType,
    val power: String,
    val capacity: String,
    val price: String,
    val description: String,
    val mark: String,
    val model: String,
    val color: String,
    val seller: String,
    val principalImageUri: String,
    val secondaryImageUris: List<String>
)
