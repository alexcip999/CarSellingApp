package com.example.car_sellingapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.car_sellingapp.data.remote.dto.BaseResponse
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.screens.Routes.MainRoute.Home.toHome
import com.example.myapplication.data.remote.PostsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    private val service = PostsService.create()

    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    var loginUsername by mutableStateOf("")
        private set

    var loginPassword by mutableStateOf("")
        private set

    fun updateUsername(username: String){
        loginUsername = username
    }

    fun updatePassword(password: String){
        loginPassword = password
    }

    fun loginUser(navController: NavController){
        val loginRequest = LoginRequest(
            username = loginUsername,
            password = loginPassword
        )

        viewModelScope.launch {
            val loginResponse = service.login(loginRequest)

            if (loginResponse.message == "Success"){
                _uiState.update { currentState ->
                    currentState.copy(isLoginWrong = false)
                }
                navController.toHome()
            }else{
                _uiState.update { currentState ->
                    currentState.copy(isLoginWrong = true)
                }
            }
        }
    }
}