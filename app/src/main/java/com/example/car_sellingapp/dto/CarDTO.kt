package com.example.car_sellingapp.dto

import androidx.compose.ui.graphics.painter.Painter


data class CarDTO(
    val kilometers: String,
    val model: String,
    val transmission: String, // enum -> Manual or Automatic
    val price: String,
    val location: String,
    val condition: String,
    val image: Painter,
)
