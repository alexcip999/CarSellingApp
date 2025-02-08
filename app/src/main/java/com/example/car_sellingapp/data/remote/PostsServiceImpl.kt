package com.example.car_sellingapp.data.remote

import com.example.car_sellingapp.data.remote.dto.BaseResponse
import com.example.car_sellingapp.data.remote.dto.ChangePasswordRequest
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.RegisterRequest
import com.example.car_sellingapp.data.remote.dto.VerifyRequest
import com.example.myapplication.data.remote.PostsService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PostsServiceImpl(
    private val client: HttpClient,
) : PostsService {

    override suspend fun login(loginRequest: LoginRequest): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.LOGIN)
                contentType(ContentType.Application.Json)
                setBody(loginRequest)
            }.body<BaseResponse>()
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error1", "Error")
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error2", "Error")
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error3", "Error")
        } catch (e: Exception) {
            println("Error: ${e.message}")
            BaseResponse("${e.message}", "Error")
        }
    }

    override suspend fun register(registerRequest: RegisterRequest): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.REGISTER)
                contentType(ContentType.Application.Json)
                setBody(registerRequest)
            }.body<BaseResponse>()

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error1", "Error")
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error2", "Error")
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error3", "Error")
        } catch (e: Exception) {
            println("Error: ${e.message}")
            BaseResponse("${e.message}", "Error")
        }
    }

    override suspend fun verify(verifyRequest: VerifyRequest): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.VERIFY)
                contentType(ContentType.Application.Json)
                setBody(verifyRequest)
            }.body<BaseResponse>()
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error1", "Error")
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error2", "Error")
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error3", "Error")
        } catch (e: Exception) {
            println("Error: ${e.message}")
            BaseResponse("${e.message}", "Error")
        }
    }

    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.CHANGE_PASSWORD)
                contentType(ContentType.Application.Json)
                setBody(changePasswordRequest)
            }.body<BaseResponse>()
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error1", "Error")
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error2", "Error")
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            BaseResponse("Error3", "Error")
        } catch (e: Exception) {
            println("Error: ${e.message}")
            BaseResponse("${e.message}", "Error")
        }
    }

}