package com.example.car_sellingapp.data.remote.dto

import com.example.car_sellingapp.data.remote.util.UUIDSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class User(
    @Serializable(with = UUIDSerializer::class) val id: UUID = UUID.randomUUID(),
    val name: String,
    val email: String,
    val password: String
)
