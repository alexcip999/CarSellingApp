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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_sellingapp.data.remote.dto.BaseResponse
import com.example.car_sellingapp.data.remote.dto.GetUsersResponse
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.LoginResponse
import com.example.car_sellingapp.data.remote.dto.PostResponse
import com.example.car_sellingapp.screens.MainNavigation
import com.example.car_sellingapp.ui.theme.CarSellingAppTheme
import com.example.myapplication.data.remote.PostsService


class MainActivity : ComponentActivity() {

    private val service = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
//            val users = produceState<List<GetUsersResponse>>(
//                initialValue = emptyList(),
//                producer = {
//                    value = service.getUsers()
//                }
//            )
//            val loginRequest = LoginRequest(
//                username = "alex",
//                password = "1234"
//            )
//            val loginResponse = produceState<BaseResponse>(
//                initialValue = BaseResponse("Error", "Error"),
//                producer = {
//                    value = service.login(loginRequest)
//                }
//            )
            CarSellingAppTheme {
                //MainNavigation()
//                Column {
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Text(loginResponse.value.toString())
//                }
            }
        }
    }
}


