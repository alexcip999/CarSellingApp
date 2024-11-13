package com.example.car_sellingapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_sellingapp.DTO.CarDTO
import com.example.car_sellingapp.R

@Composable
fun CarCard(car: CarDTO) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier =
            Modifier
                .padding(16.dp)
                .width(300.dp),
    ) {
        Column {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(180.dp),
            ) {
                Image(
                    painter = car.image,
                    contentDescription = "Image of car",
                    modifier =
                        Modifier
                            .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(modifier = Modifier.padding(2.dp))
            Row(
                modifier = Modifier.padding(4.dp),
            ) {
                Text(
                    text = car.model,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
            }
            Column {
                Row(
                    modifier =
                        Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row {
                        Text(
                            text = car.kilometers.toString() + " KM",
                            fontSize = 12.sp,
                            color = Color.Black,
                        )
                    }
                    Row {
                        Text(
                            text = car.transmission,
                            fontSize = 12.sp,
                            color = Color.Black,
                        )
                    }
                    Row {
                        Text(
                            text = "condition: ",
                            fontSize = 12.sp,
                        )
                        Text(
                            text = car.condition,
                            fontSize = 12.sp,
                            color = Color.Black,
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "price: ",
                            fontSize = 12.sp,
                        )
                        Text(
                            text = car.price.toString() + " EUR",
                            color = Color(0xFFFF4081),
                        )
                    }
                    Row {
                        Text(
                            text = car.location,
                            fontSize = 12.sp,
                            color = Color.Black,
                        )
                    }

                    IconButton(onClick = { /* TODO: Favorite action */ }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite Icon",
                            tint = Color.Gray,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ExampleCarCard() {
    CarCard(
        car =
            CarDTO(
                kilometers = "5.000",
                model = "Mercedes G Class Brabus 2024",
                transmission = "Automatic",
                price = "324.900,00",
                location = "Germany",
                condition = "New",
                image = painterResource(id = R.drawable.masina1),
            ),
    )
}
