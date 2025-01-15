package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.car_sellingapp.R
import com.example.car_sellingapp.components.BottomBarComponent
import com.example.car_sellingapp.data.remote.dto.CarDTO
import com.example.car_sellingapp.data.remote.dto.CombustibleType
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel

@Composable
fun CarDetailsScreen(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
) {
    val car = appUiState.currentCar

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "Car Details",
            modifier =
            Modifier
                .fillMaxSize()
                .blur(8.dp),
            contentScale = ContentScale.Crop,
        )
    }
    Column {
        LazyColumn(
            modifier = Modifier
                .height(780.dp)
                .padding(16.dp)
        ) {
            item {
                // Principal Image
                if (car != null) {
                    Image(
                        painter = painterResource(R.drawable.masina1),
                        contentDescription = "${car.mark} ${car.model}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Title
                if (car != null) {
                    Text(
                        text = "${car.mark} ${car.model} (${car.year})",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Seller Info
                if (car != null) {
                    Text(
                        text = "Seller: ${car.seller}",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Car Details
                Text(
                    text = "Details:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                if (car != null) {
                    Text("Price: \$${car.price}", fontSize = 16.sp, color = Color.Black)
                }
                if (car != null) {
                    Text("KM: ${car.km} km", fontSize = 16.sp, color = Color.Black)
                }
                if (car != null) {
                    Text("Combustible: ${car.combustible}", fontSize = 16.sp, color = Color.Black)
                }
                if (car != null) {
                    Text("Power: ${car.power}", fontSize = 16.sp, color = Color.Black)
                }
                if (car != null) {
                    Text("Capacity: ${car.capacity}", fontSize = 16.sp, color = Color.Black)
                }
                if (car != null) {
                    Text("Color: ${car.color}", fontSize = 16.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Description
                Text(
                    text = "Description:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                if (car != null) {
                    Text(text = car.description, fontSize = 16.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Secondary Images
                Text(
                    text = "Gallery:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
                car?.secondaryImageUris?.forEach { imageUrl ->
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = "Gallery Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }
        BottomBarComponent(navController, appViewModel, appUiState)
    }


}


