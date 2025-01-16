package com.example.car_sellingapp.components


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.sharp.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel
import com.example.car_sellingapp.screens.Routes.MainRoute.FavoriteCars.toFavorite
import com.example.car_sellingapp.screens.Routes.MainRoute.Home.toHome
import com.example.car_sellingapp.screens.Routes.MainRoute.Profile.toProfile
import com.example.car_sellingapp.screens.Routes.MainRoute.UploadCar.toUploadCar
import com.example.car_sellingapp.screens.Routes.MainRoute.YourPosts.toYourPosts

@Composable
fun BottomBarComponent(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        actions = {
                IconButton(onClick = { navController.toProfile() }) {
                    Icon(Icons.Filled.Person, contentDescription = "Profile")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = {
                    appViewModel.getAllCars()
                    navController.toHome()
                }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = {navController.toUploadCar() }) {
                    Icon(Icons.Sharp.AddCircle, contentDescription = "Add new post")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = {
                    appViewModel.getFavCars()
                    navController.toFavorite()
                }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite Posts")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = {
                    appViewModel.getCarsById()
                    navController.toYourPosts()
                }) {
                    Icon(
                        painterResource(R.drawable.car_tag_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                        contentDescription = "Your Posts"
                    )
                }
        },
    )
}