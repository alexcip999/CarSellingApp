package com.example.car_sellingapp.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.car_sellingapp.R

@Composable
@Preview
fun BottomBarComponent() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Person, contentDescription = "Localized description")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Home, contentDescription = "Go Home")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = { }) {
                    Icon(Icons.Sharp.AddCircle, contentDescription = "Add new post")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite Posts")
                }
                Spacer(modifier = Modifier.padding(18.dp))
                IconButton(onClick = { }) {
                    Icon(
                        painterResource(R.drawable.chat_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                        contentDescription = "Chat"
                    )
                }
        },
    )
}