package com.example.car_sellingapp.data.remote.dto



data class CarDto(
    // common id from the user who upload this car
    val idUser: Int,
    // details for card component
    val year: String,
    val km: String,
    val combustible: CombustibleType,
    val power: String,
    val capacity: String,
    val price: String,
    // more details
    val description: String,
    val mark: String,
    val color: String,
    val seller: String,
)

enum class CombustibleType(private val displayName: String) {
    GASOLINE("Gasoline"),
    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    HYBRID("Hybrid"),
    BENZINE("Benzine");

    override fun toString(): String = displayName
}
