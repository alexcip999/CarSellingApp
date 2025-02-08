package com.example.myapplication.data.remote

import com.example.car_sellingapp.data.remote.PostsServiceImpl
import com.example.car_sellingapp.data.remote.dto.BaseResponse
import com.example.car_sellingapp.data.remote.dto.ChangePasswordRequest
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.RegisterRequest
import com.example.car_sellingapp.data.remote.dto.VerifyRequest
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

interface PostsService {

    suspend fun login(loginRequest: LoginRequest): BaseResponse

    suspend fun register(registerRequest: RegisterRequest): BaseResponse

    suspend fun verify(verifyRequest: VerifyRequest) : BaseResponse

    suspend fun changePassword(changePasswordRequest: ChangePasswordRequest) : BaseResponse

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