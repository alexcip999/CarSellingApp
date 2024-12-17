package com.example.car_sellingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_sellingapp.data.remote.dto.GetUsersResponse
import com.example.car_sellingapp.data.remote.dto.PostResponse
import com.example.car_sellingapp.screens.MainNavigation
import com.example.car_sellingapp.ui.theme.CarSellingAppTheme
import com.example.myapplication.data.remote.PostsService


class MainActivity : ComponentActivity() {

    private val service = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val posts = produceState<List<GetUsersResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = service.getUsers()
                }
            )
            CarSellingAppTheme {
                //MainNavigation()
                Surface(color = MaterialTheme.colorScheme.background){
                    LazyColumn {
                        items(posts.value){
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(text = it.username, fontSize = 20.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = it.password, fontSize = 14.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}


