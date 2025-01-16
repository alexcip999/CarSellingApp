package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.components.BottomBarComponent
import com.example.car_sellingapp.components.CarCard
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel

@Composable
fun SearchCarsScreen(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "White Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Mark: " + appViewModel.searchCarsByMark,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .padding(8.dp)
                .height(680.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top
        ) {
            // Title for the screen

            Spacer(modifier = Modifier.height(20.dp))
            appUiState.searchCarsByMark.forEach{ car ->
                CarCard(
                    car = car,
                    navController = navController,
                    appViewModel = appViewModel,
                    appUiState = appUiState,
                )
            }
        }
        BottomBarComponent(
            navController = navController,
            appViewModel = appViewModel,
            appUiState = appUiState
        )
    }

}


