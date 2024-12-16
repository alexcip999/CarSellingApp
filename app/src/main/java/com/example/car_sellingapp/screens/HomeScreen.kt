package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.car_sellingapp.R
import com.example.car_sellingapp.components.CardSlider
import com.example.car_sellingapp.dto.CarDTO

@Preview
@Composable
fun HomeScreen() {
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
    val card1: CarDTO =
        CarDTO(
            kilometers = "5.000",
            model = "Mercedes G Class Brabus 2024",
            transmission = "Automatic",
            price = "324.900,00",
            location = "Germany",
            condition = "New",
            image = painterResource(id = R.drawable.masina1),
        )
    val card2: CarDTO =
        CarDTO(
            kilometers = "121.699",
            model = "Mercedes-Benz GLS 400 d 4MATIC Aut.",
            transmission = "Automatic",
            price = "70.091,00",
            location = "Romania",
            condition = "Used",
            image = painterResource(id = R.drawable.masina2),
        )
    val card3: CarDTO =
        CarDTO(
            kilometers = "19.300",
            model = "Audi A5 Sportnack 35 TDI S tronic S line",
            transmission = "Automatic",
            price = "42.500,00",
            location = "Romania",
            condition = "Used",
            image = painterResource(id = R.drawable.masina3),
        )
    val card4: CarDTO =
        CarDTO(
            kilometers = "265.000",
            model = "Mercedes-Benz S 350 d BlueTEC 4M Long Aut",
            transmission = "Automatic",
            price = "27.500,00",
            location = "Romania",
            condition = "Used",
            image = painterResource(id = R.drawable.masina4),
        )
    val cars1 = mutableListOf<CarDTO>()
    val cars2 = mutableListOf<CarDTO>()
    cars1.add(card1)
    cars1.add(card2)
    cars2.add(card3)
    cars2.add(card4)

    Column(
        modifier =
            Modifier
                .padding(4.dp)
                .fillMaxSize(),
    ) {
        Column(
            modifier =
                Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
        ) {
            val text = remember { mutableStateOf("") }
            Spacer(modifier = Modifier.padding(16.dp))
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
                onSearchClicked = {
                    println()
                },
                onTextChange = { text.value = it },
            )
            Spacer(modifier = Modifier.padding(4.dp))
            LazyColumn {
                item {
                    Spacer(modifier = Modifier.padding(8.dp))
                    CardSlider(cars2)
                }
                item {
                    Spacer(modifier = Modifier.padding(8.dp))
                    CardSlider(cars1)
                }
                item {
                    Spacer(modifier = Modifier.padding(8.dp))
                    CardSlider(cars1)
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    height: Dp = 40.dp,
    elevation: Dp = 3.dp,
    cornerShape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.White,
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
) {
    // var text = remember { mutableStateOf("") }
    Row(
        modifier =
            Modifier
                .height(height)
                .fillMaxWidth()
                .shadow(elevation = elevation, shape = cornerShape)
                .background(color = backgroundColor, shape = cornerShape)
                .clickable { onSearchClicked() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            modifier =
                modifier
                    .weight(5f)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            value = text,
            onValueChange = onTextChange,
            enabled = isEnabled,
            textStyle =
                TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = hint,
                        color = Color.Gray.copy(alpha = 0.5f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                innerTextField()
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ),
            keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
            singleLine = true,
        )
        Box(
            modifier =
                modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .size(40.dp)
                    .background(color = Color.Transparent, shape = CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            if (text.isEmpty()) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            } else {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
        }
    }
}
