package com.example.car_sellingapp.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.RegisterRequest
import com.example.car_sellingapp.data.remote.dto.VerifyRequest
import com.example.car_sellingapp.screens.Routes.MainRoute.ForgotPassword.toForgotPassword
import com.example.car_sellingapp.screens.Routes.MainRoute.Home.toHome
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin
import com.example.car_sellingapp.screens.Routes.MainRoute.PopUpChgPass.toChgPass
import com.example.car_sellingapp.screens.Routes.MainRoute.PopUpRegister.toPopUpRegister
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

    // Login fields
    var loginEmail by mutableStateOf("")
        private set

    fun updateLoginEmail(email: String){
        loginEmail = email
    }

    var loginPassword by mutableStateOf("")
        private set

    fun updateLoginPassword(password: String){
        loginPassword = password
    }

    // Register fields
    var registerName by mutableStateOf("")
        private set

    fun updateRegisterName(name: String){
        registerName = name
    }

    var registerEmail by mutableStateOf("")
        private set

    fun updateRegisterEmail(email: String){
        registerEmail = email
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

    // Verify email field
    var verifyEmail by mutableStateOf("")
        private set

    fun updateVerifyEmail(email: String){
        verifyEmail = email
    }

    fun verifyUser(navController: NavController){
        val verifyRequest = VerifyRequest(
            email = verifyEmail
        )

        viewModelScope.launch {
            val verifyResponse = service.verify(verifyRequest)
            if (verifyResponse.data == "Invalid user email"){
                _uiState.update { currentState ->
                    currentState.copy(
                        isVerifyWrong = true,
                        currentErrorVerify = verifyResponse.data
                    )
                }
            }else{
                _uiState.update { currentState ->
                    verifyResponse.data?.let {
                        currentState.copy(
                            isVerifyWrong = false,
                            currentErrorVerify = it
                        )
                    }!!
                }
                navController.toForgotPassword()
            }
        }
    }

    fun loginUser(navController: NavController){
        val loginRequest = LoginRequest(
            email = loginEmail,
            password = loginPassword
        )

        viewModelScope.launch {
            val loginResponse = service.login(loginRequest)
            if (loginResponse.message == "Success"){
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoginWrong = false,
                        isLoginEmailWrong = false,
                        isLoginPassWrong = false
                    )
                }
                updateLoginEmail("")
                updateLoginPassword("")
                navController.toHome()
            }else{
                if (loginResponse.data == "Wrong Password"){
                    _uiState.update { currentState ->
                        currentState.copy(
                            isLoginWrong = true,
                            isLoginPassWrong = true,
                            isLoginEmailWrong = false,
                            currentErrorLogin = loginResponse.data.toString()
                        )
                    }
                }else{
                    _uiState.update { currentState ->
                        currentState.copy(
                            isLoginWrong = true,
                            isLoginEmailWrong = true,
                            isLoginPassWrong = false,
                            currentErrorLogin = loginResponse.data.toString()
                        )
                    }
                }
            }
        }
    }

    fun registerUser(navController: NavController) {
        val registerRequest = RegisterRequest(
            name = registerName,
            email = registerEmail,
            password = registerPassword,
            passwordConfirmation = registerPasswordConfirmation
        )

        viewModelScope.launch {
            if(registerPassword.isNotEmpty() && registerPasswordConfirmation.isNotEmpty()){
                val registerResponse = service.register(registerRequest)

                if (registerResponse.message == "Success"){
                    _uiState.update { currentState ->
                        currentState.copy(isRegisterWrong = false)
                    }
                    updateRegisterName("")
                    updateRegisterEmail("")
                    updateRegisterPassword("")
                    updateRegisterPasswordConfirmation("")

                    navController.toPopUpRegister()
                }else{
                    if (registerResponse.data == "Username already exists"){
                        _uiState.update { currentState ->
                            currentState.copy(
                                isRegisterWrong = true,
                                isRegisterEmailInvalid = false,
                                isRegisterNameWrong = true,
                                isRegisterEmailWrong = false,
                                isRegisterPasswordsWrong = false,
                                currentErrorRegister = registerResponse.data.toString()
                            )
                        }
                    }else{
                        if (registerResponse.data == "Passwords do not match"){
                            _uiState.update { currentState ->
                                currentState.copy(
                                    isRegisterWrong = true,
                                    isRegisterEmailInvalid = false,
                                    isRegisterNameWrong = false,
                                    isRegisterEmailWrong = false,
                                    isRegisterPasswordsWrong = true,
                                    currentErrorRegister = registerResponse.data.toString()
                                )
                            }
                        }else{
                            if (registerResponse.data == "Invalid email format"){
                                _uiState.update { currentState ->
                                    currentState.copy(
                                        isRegisterWrong = true,
                                        isRegisterEmailInvalid = true,
                                        isRegisterNameWrong = false,
                                        isRegisterEmailWrong = false,
                                        isRegisterPasswordsWrong = false,
                                        currentErrorRegister = registerResponse.data.toString()
                                    )
                                }
                            }else{
                                _uiState.update { currentState ->
                                    currentState.copy(
                                        isRegisterWrong = true,
                                        isRegisterEmailInvalid = false,
                                        isRegisterNameWrong = false,
                                        isRegisterEmailWrong = true,
                                        isRegisterPasswordsWrong = false,
                                        currentErrorRegister = registerResponse.data.toString()
                                    )
                                }
                            }
                        }

                    }
                    _uiState.update { currentState ->
                        currentState.copy(
                            isRegisterWrong = true,
                            currentErrorRegister = registerResponse.data.toString()
                        )
                    }
                }
            }else{
                _uiState.update { currentState ->
                    currentState.copy(
                        isRegisterWrong = true,
                        isRegisterEmailInvalid = false,
                        isRegisterNameWrong = false,
                        isRegisterEmailWrong = false,
                        isRegisterPasswordsWrong = true,
                        currentErrorRegister = "Empty passwords fields"
                    )
                }
            }
        }
    }

}