package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.components.BottomBarComponent


@Composable
fun ProfileScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "White background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(770.dp)
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.account_circle_100dp_e8eaed_fill0_wght400_grad0_opsz48),
                contentDescription = "Account image",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Username",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(64.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ){
                Text(
                    text = "Name: --------",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Tel: --------",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Your Posts: --------",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(32.dp))
            }

        }
        BottomBarComponent(navController)
    }

}