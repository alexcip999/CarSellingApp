package com.example.car_sellingapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_sellingapp.R

@Composable
fun CarCard(
    image: @Composable () -> Unit,
    name: @Composable () -> Unit,
    description: @Composable () -> Unit,
    price: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(8.dp),
        // elevation = 4.dp,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            image()
            name()
            description()
            price()
        }
    }
}

@Preview
@Composable
fun ExampleCarCard() {
    CarCard(
        image = {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Image of car",
                modifier =
                    Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                contentScale = ContentScale.Crop,
            )
        },
        name = {
            Text(
                text = "Masina",
                modifier = Modifier.padding(4.dp),
                fontSize = 20.sp,
            )
        },
        description = {
            Text(
                text = "masina cu multi cai putere",
                modifier = Modifier.padding(4.dp),
                fontSize = 12.sp,
            )
        },
        price = {
            Text(
                text = "1000.00$",
                modifier = Modifier.padding(8.dp),
            )
        },
    )
}

@Composable
fun MyCardComponent(
    title: String = "",
    content: @Composable () -> Unit,
    padding: Dp,
    backgroundColor: Color,
    elevation: CardElevation,
) {
    Card(
        modifier = Modifier.padding(padding),
        elevation = elevation,
        colors =
            CardDefaults.cardColors(
                containerColor = backgroundColor,
            ),
    ) {
        if (!title.isEmpty()) {
            Text(
                text = title,
                fontSize = 10.sp,
            )
        }
        content()
    }
}

@Preview
@Composable
fun PreviewMyCardComponent()  {
    MyCardComponent(
        content = {
            ExampleCarCard()
        },
        padding = 10.dp,
        elevation = CardDefaults.elevatedCardElevation(),
        backgroundColor = Color.Cyan,
    )
}

@Preview
@Composable
fun Component1()  {
    MyCardComponent(
        title = "Salutare",
        content = {},
        padding = 10.dp,
        backgroundColor = Color.White,
        elevation = CardDefaults.elevatedCardElevation(),
    )
}
