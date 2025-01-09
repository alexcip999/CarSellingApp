package com.example.car_sellingapp.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.car_sellingapp.data.remote.dto.CombustibleType
import com.example.car_sellingapp.data.remote.dto.ForgotPasswordRequest
import com.example.car_sellingapp.data.remote.dto.GetUserByUsername
import com.example.car_sellingapp.data.remote.dto.GetUserDetailsRequest
import com.example.car_sellingapp.data.remote.dto.GetUserDetailsResponse
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.ParamSaveDetailsAboutUser
import com.example.car_sellingapp.data.remote.dto.RegisterRequest
import com.example.car_sellingapp.data.remote.dto.UploadCarRequest
import com.example.car_sellingapp.screens.Routes.MainRoute.Home.toHome
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin
import com.example.car_sellingapp.screens.Routes.MainRoute.Profile.toProfile
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

    var forgotPassUsername by mutableStateOf("")
        private set

    fun updateForgotPassUsername(username: String){
        forgotPassUsername = username
    }

    var forgotPassNewPassword by mutableStateOf("")
        private set

    fun updateForgotPassNewPassword(newPassword: String){
        forgotPassNewPassword = newPassword
    }

    var forgotPassConfirmPassword by mutableStateOf("")
        private set

    fun updateForgotPassConfirmPassword(confirmPassword: String){
        forgotPassConfirmPassword = confirmPassword
    }

    var dataName by mutableStateOf("")
        private set

    fun updateDataName(name: String){
        dataName = name
    }

    var dataCountry by mutableStateOf("")
        private set

    fun updateDataCountry(country: String){
        dataCountry = country
    }

    var dataCity by mutableStateOf("")
        private set

    fun updateDataCity(city: String){
        dataCity = city
    }

    var dataPhone by mutableStateOf("")
        private set

    fun updateDataPhone(phone: String){
        dataPhone = phone
    }

    var uploadMark by mutableStateOf("")
        private set

    fun updateUploadMark(mark: String){
        uploadMark = mark
    }

    var uploadSelectedCombustibleType by mutableStateOf(CombustibleType.GASOLINE)
        private set

    fun updateUploadCombustibleType(combustibleType: CombustibleType){
        uploadSelectedCombustibleType = combustibleType
    }

    var uploadColor by mutableStateOf("")
        private set

    fun updateUploadColor(color: String){
        uploadColor = color
    }

    var uploadModel by mutableStateOf("")
        private set

    fun updateUploadModel(model: String){
        uploadModel = model
    }

    var uploadPower by mutableStateOf("")
        private set

    fun updateUploadPower(power: String){
        uploadPower = power
    }

    var uploadPrice by mutableStateOf("")
        private set

    fun updateUploadPrice(price: String){
        uploadPrice = price
    }

    var uploadYear by mutableStateOf("")
        private set

    fun updateUploadYear(year: String){
        uploadYear = year
    }

    var uploadMileage by mutableStateOf("")
        private set

    fun updateUploadMileage(mileage: String){
        uploadMileage = mileage
    }

    var uploadCapacity by mutableStateOf("")
        private set

    fun updateUploadCapacity(capacity: String){
        uploadCapacity = capacity
    }

    var uploadDescription by mutableStateOf("")
        private set

    fun updateUploadDescription(description: String){
        uploadDescription = description
    }


    fun uploadCar(navController: NavController){

        val uploadCarRequest = uiState.value.currentUser?.let {
            uiState.value.profileDetails?.name?.let { it1 ->
                UploadCarRequest(
                    idUser = it.id,
                    year = uploadYear,
                    km = uploadMileage,
                    combustible = uploadSelectedCombustibleType,
                    power = uploadPower,
                    capacity = uploadCapacity,
                    price = uploadPrice,
                    description = uploadDescription,
                    mark = uploadDescription,
                    model = uploadModel,
                    color = uploadColor,
                    seller = it1,
                    principalImageUri = "",
                    secondaryImageUris = emptyList()
                )
            }
        }

        viewModelScope.launch {
            if (uploadCarRequest != null){
                val response = service.uploadCar(uploadCarRequest)
                if (response.message == "Success"){
                    _uiState.update { currentState ->
                        currentState.copy(isUploadCarWrong = false)
                    }
                    navController.toHome()
                }else{
                    _uiState.update { currentState ->
                        currentState.copy(isUploadCarWrong = true)
                    }
                }
            }

        }
    }


    fun loginUser(navController: NavController){
        val loginRequest = LoginRequest(
            username = loginUsername,
            password = loginPassword
        )

        viewModelScope.launch {
            val loginResponse = service.login(loginRequest)
            if (loginResponse.message == "Success"){
                val getUserByUsername = service.getUserByUsername(
                    GetUserByUsername(loginUsername)
                ).data
                if (getUserByUsername != null){
                    val getDetailsAboutUser = service.getDetailsAboutUser(
                        GetUserDetailsRequest(getUserByUsername.id)
                    )
                    if (getDetailsAboutUser.isNotEmpty()){
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoginWrong = false,
                                currentUser = getUserByUsername,
                                profileDetails = getDetailsAboutUser[0]
                            )
                        }
                    }else{
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoginWrong = false,
                                currentUser = getUserByUsername,
                            )
                        }
                    }
                    navController.toHome()
                }

            }else{
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoginWrong = true
                    )
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

    fun forgotPassword(navController: NavController){
        val forgotPasswordRequest = ForgotPasswordRequest(
            username = forgotPassUsername,
            password = forgotPassNewPassword,
            passwordConfirmation = forgotPassConfirmPassword
        )

        viewModelScope.launch {
            val forgotPassResponse = service.forgotPassword(forgotPasswordRequest)

            if (forgotPassResponse.message == "Success"){
                _uiState.update { currentState ->
                    currentState.copy(isForgotPasswordWrong = false)
                }
                navController.toLogin()
            }else{
                _uiState.update { currentState ->
                    currentState.copy(isForgotPasswordWrong = true)
                }
            }
        }
    }

    fun saveDetailsAboutUser(navController: NavController) {
        val saveDetails = uiState.value.currentUser?.let {
            ParamSaveDetailsAboutUser(
                userId = it.id,
                name = dataName,
                country = dataCountry,
                city = dataCity,
                phone = dataPhone,
                profileImageUri = ""
            )
        }

        if (saveDetails == null) {
            Log.d("SaveDetails", "saveDetails is null, cannot proceed.")
            return
        }

        viewModelScope.launch {
            try {
                val response = service.saveDetailsAboutUser(saveDetails)

                if (response.message == "Success") {
                    val getUserDetailsResponse = GetUserDetailsResponse(
                        userId = saveDetails.userId,
                        name = saveDetails.name,
                        country = saveDetails.country,
                        city = saveDetails.city,
                        phone = saveDetails.phone,
                        profileImageUri = saveDetails.profileImageUri
                    )

                    _uiState.update { currentState ->
                        currentState.copy(
                            isUpdateWrong = false,
                            profileDetails = getUserDetailsResponse
                        )
                    }

                    navController.toProfile()
                } else {
                    Log.d("SaveDetails", "Error in response: ${response.message}")
                    _uiState.update { currentState ->
                        currentState.copy(
                            isUpdateWrong = true,
                        )
                    }
                }
            } catch (e: Exception) {
                Log.e("SaveDetails", "Error occurred: ${e.message}")
                _uiState.update { currentState ->
                    currentState.copy(
                        isUpdateWrong = true,
                    )
                }
            }
        }
    }



}