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
            text = text.value,
            hint = "Search",
            onSearchClicked = { },
            onTextChange = { text.value = it },
        )

        Spacer(modifier = Modifier.padding(4.dp))
        LazyColumn(
            modifier = Modifier
                .height(650.dp)
        ) {
                item {
                    Spacer(modifier = Modifier.padding(8.dp))
                    CardSlider(appUiState.allCars, navController, appViewModel, appUiState)
                }

        }
        BottomBarComponent(navController, appViewModel, appUiState)
    }
}


