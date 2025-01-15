package com.example.myapplication.data.remote

import com.example.car_sellingapp.data.remote.PostsServiceImpl
import com.example.car_sellingapp.data.remote.dto.BaseResponse
import com.example.car_sellingapp.data.remote.dto.CarDTO
import com.example.car_sellingapp.data.remote.dto.ForgotPasswordRequest
import com.example.car_sellingapp.data.remote.dto.GetAllCars
import com.example.car_sellingapp.data.remote.dto.GetUserByUsername
import com.example.car_sellingapp.data.remote.dto.GetUserDetailsRequest
import com.example.car_sellingapp.data.remote.dto.GetUserDetailsResponse
import com.example.car_sellingapp.data.remote.dto.GetUsersResponse
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.ParamSaveDetailsAboutUser
import com.example.car_sellingapp.data.remote.dto.ProfileResponse
import com.example.car_sellingapp.data.remote.dto.RegisterRequest
import com.example.car_sellingapp.data.remote.dto.UploadCarRequest
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


interface PostsService {

    suspend fun getUsers(): List<GetUsersResponse>

    suspend fun login(loginRequest: LoginRequest): BaseResponse

    suspend fun register(registerRequest: RegisterRequest): BaseResponse

    suspend fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): BaseResponse

    suspend fun uploadCar(uploadCarRequest: UploadCarRequest): BaseResponse

    suspend fun getUserByUsername(findUserByUsername: GetUserByUsername): ProfileResponse

    suspend fun getDetailsAboutUser(getUserDetails: GetUserDetailsRequest): List<GetUserDetailsResponse?>

    suspend fun saveDetailsAboutUser(params: ParamSaveDetailsAboutUser): BaseResponse

    suspend fun getAllCars(): List<CarDTO>

    companion object {
        fun create(): PostsService {
            return PostsServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }

                    install(DefaultRequest) {
                        header(HttpHeaders.ContentType, ContentType.Application.Json)
                    }

                    install(ContentNegotiation) {
                        json()
                    }
                }
            )
        }
    }
}