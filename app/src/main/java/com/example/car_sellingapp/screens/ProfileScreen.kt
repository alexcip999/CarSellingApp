package com.example.car_sellingapp.screens

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.components.BottomBarComponent
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel
import com.example.car_sellingapp.screens.Routes.MainRoute.UpdateProfile.toUpdateProfile


@Composable
fun ProfileScreen(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
){

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
                text = "Username: ${appUiState.currentUser?.username}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ){
                Text(
                    text = "Name: ${appUiState.profileDetails?.name}",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Country: ${appUiState.profileDetails?.country}",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "City: ${appUiState.profileDetails?.city}",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Phone: ${appUiState.profileDetails?.phone}",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(20.dp))

            }
            Button(
                    onClick = {
                        navController.toUpdateProfile()
                    },
            ) {
            Text(
                text = "Update data",
            )
        }

        }

        BottomBarComponent(navController)
    }

}



