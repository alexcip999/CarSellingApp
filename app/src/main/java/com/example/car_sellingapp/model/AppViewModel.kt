package com.example.car_sellingapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.RegisterRequest
import com.example.car_sellingapp.screens.Routes.MainRoute.Home.toHome
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin
import com.example.car_sellingapp.screens.Routes.MainRoute.SignUp.toSignUp
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

    fun updateLoginUsername(username: String){
        loginUsername = username
    }

    var loginPassword by mutableStateOf("")
        private set

    fun updateLoginPassword(password: String){
        loginPassword = password
    }

    var registerUsername by mutableStateOf("")
        private set

    fun updateRegisterUsername(username: String){
        registerUsername = username
    }

    var registerPassword by mutableStateOf("")
        private set

    fun updateRegisterPassword(password: String){
        registerPassword = password
    }

    var registerPasswordConfirmation by mutableStateOf("")
        private set

    fun updateRegisterPasswordConfirmation(passwordConfirmation: String){
        registerPasswordConfirmation = passwordConfirmation
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

    fun registerUser(navController: NavController) {
        val registerRequest = RegisterRequest(
            username = registerUsername,
            password = registerPassword,
            passwordConfirmation = registerPasswordConfirmation
        )

        viewModelScope.launch {
            val registerResponse = service.register(registerRequest)

            if (registerResponse.message == "Success"){
                _uiState.update { currentState ->
                    currentState.copy(isRegisterWrong = false)
                }
                navController.toLogin()
            }else{
                _uiState.update { currentState ->
                    currentState.copy(isRegisterWrong = true)
                }
            }
        }
    }
}