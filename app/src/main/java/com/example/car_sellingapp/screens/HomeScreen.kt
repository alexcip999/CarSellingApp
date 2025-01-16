package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.components.BottomBarComponent
import com.example.car_sellingapp.components.CardSlider
import com.example.car_sellingapp.components.SearchBar
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel

val listOfMarks = listOf("Toyota", "Audi", "BMW", "Mercedes-Benz", "Ford")

@Composable
fun HomeScreen(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
) {
    Box(
        modifier =
        Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "White Background",
            modifier =
            Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }

    Column(
        modifier =
        Modifier
            .padding(4.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        val text = remember { mutableStateOf("") }
        Text(
            text = "Featured",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "6.046 Cars for Sale in USA",
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.padding(4.dp))
        SearchBar(
            text = appViewModel.searchCarsByMark,
            hint = "Search",
            onSearchClicked = { appViewModel.getCarsByMark()},
            onTextChange = { appViewModel.updateSearchCarByMark(it) },
            navController = navController
        )

        Spacer(modifier = Modifier.padding(4.dp))
        LazyColumn(
            modifier = Modifier
                .height(650.dp)
        ) {
            items(listOfMarks) { mark ->
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "Mark: $mark",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))

                // Filter cars by mark and display in CardSlider
                val filteredCars = appUiState.allCars.filter { car -> car.mark == mark }
                if (filteredCars.isNotEmpty()) {
                    CardSlider(
                        cards = filteredCars,
                        navController = navController,
                        appViewModel = appViewModel,
                        appUiState = appUiState
                    )
                } else {
                    Text(
                        text = "No cars available for $mark",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

        }
        BottomBarComponent(navController, appViewModel, appUiState)
    }
}


