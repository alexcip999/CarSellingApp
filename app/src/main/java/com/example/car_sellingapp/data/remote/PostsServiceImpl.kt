package com.example.car_sellingapp.data.remote

import android.util.Log
import com.example.car_sellingapp.data.remote.dto.BaseResponse
import com.example.car_sellingapp.data.remote.dto.CarDTO
import com.example.car_sellingapp.data.remote.dto.FavsParam
import com.example.car_sellingapp.data.remote.dto.ForgotPasswordRequest
import com.example.car_sellingapp.data.remote.dto.GetAllCars
import com.example.car_sellingapp.data.remote.dto.GetCarsByIdParam
import com.example.car_sellingapp.data.remote.dto.GetCarsByMark
import com.example.car_sellingapp.data.remote.dto.GetFavCarsById
import com.example.car_sellingapp.data.remote.dto.GetUserByUsername
import com.example.car_sellingapp.data.remote.dto.GetUserDetailsRequest
import com.example.car_sellingapp.data.remote.dto.GetUserDetailsResponse
import com.example.car_sellingapp.data.remote.dto.GetUsersResponse
import com.example.car_sellingapp.data.remote.dto.LoginRequest
import com.example.car_sellingapp.data.remote.dto.ParamSaveDetailsAboutUser
import com.example.car_sellingapp.data.remote.dto.ProfileResponse
import com.example.car_sellingapp.data.remote.dto.RegisterRequest
import com.example.car_sellingapp.data.remote.dto.UploadCarRequest
import com.example.myapplication.data.remote.PostsService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PostsServiceImpl(
    private val client: HttpClient,
) : PostsService {

    override suspend fun getUsers(): List<GetUsersResponse> {
        return try {
            client.get { url(HttpRoutes.GET_USERS) }.body<List<GetUsersResponse>>()
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            Log.d("WTF_COAIE", "A dat eroare sa moara jacksana $e")
            println("Error: ${e.message}")
            emptyList()
        }
    }

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

    override suspend fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.FORGOT)
                contentType(ContentType.Application.Json)
                setBody(forgotPasswordRequest)
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

    override suspend fun uploadCar(uploadCarRequest: UploadCarRequest): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.UPLOAD_CAR)
                contentType(ContentType.Application.Json)
                setBody(uploadCarRequest)
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

    override suspend fun getUserByUsername(findUserByUsername: GetUserByUsername): ProfileResponse {
        return try {
            client.post{
                url(HttpRoutes.PROFILE)
                contentType(ContentType.Application.Json)
                setBody(findUserByUsername)
            }.body<ProfileResponse>()

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            ProfileResponse()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            ProfileResponse()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            ProfileResponse()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            ProfileResponse()
        }
    }

    override suspend fun getDetailsAboutUser(getUserDetails: GetUserDetailsRequest): List<GetUserDetailsResponse?> {
        return try {
            client.post{
                url(HttpRoutes.PROFILE_DETAILS)
                contentType(ContentType.Application.Json)
                setBody(getUserDetails)
            }.body<List<GetUserDetailsResponse?>>()

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun saveDetailsAboutUser(params: ParamSaveDetailsAboutUser): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.SAVE_DETAILS_PROFILE)
                contentType(ContentType.Application.Json)
                setBody(params)
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
            BaseResponse("Error4", "Error")
        }
    }

    override suspend fun getAllCars(): List<CarDTO> {
        return try {
            client.get { url(HttpRoutes.GET_ALL_CARS) }.body<List<CarDTO>>()
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            Log.d("1", e.message)
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            Log.d("2", e.message)
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            Log.d("3", e.message)
            emptyList()
        } catch (e: Exception) {
            e.message?.let { Log.d("4", it) }
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun addFavCar(param: FavsParam): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.ADD_FAV_CAR)
                contentType(ContentType.Application.Json)
                setBody(param)
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
            BaseResponse("Error4", "Error")
        }
    }

    override suspend fun getAllFavCArs(param: GetFavCarsById): List<CarDTO> {
        return try {
            client.post{
                url(HttpRoutes.GET_FAV_CARS)
                contentType(ContentType.Application.Json)
                setBody(param)
            }.body<List<CarDTO>>()

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getCarsById(param: GetCarsByIdParam): List<CarDTO> {
        return try {
            client.post{
                url(HttpRoutes.GET_CARS_BY_ID)
                contentType(ContentType.Application.Json)
                setBody(param)
            }.body<List<CarDTO>>()

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            Log.d("Acolo", e.message)
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            Log.d("Acolo", e.message)
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            Log.d("Acolo", e.message)
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            Log.d("Acolo", e.toString())
            emptyList()
        }
    }

    override suspend fun removeFavCar(param: FavsParam): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.REMOVE_FAV)
                contentType(ContentType.Application.Json)
                setBody(param)
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
            BaseResponse("Error4", "Error")
        }
    }

    override suspend fun isFav(param: FavsParam): BaseResponse {
        return try {
            client.post{
                url(HttpRoutes.IS_FAV)
                contentType(ContentType.Application.Json)
                setBody(param)
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
            BaseResponse("Error4", "Error")
        }
    }

    override suspend fun getCarsByMark(param: GetCarsByMark): List<CarDTO> {
        return try {
            client.post{
                url(HttpRoutes.GET_CAR_BY_MARK)
                contentType(ContentType.Application.Json)
                setBody(param)
            }.body<List<CarDTO>>()

        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            Log.d("Acolo", e.message)
            emptyList()
        } catch (e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            Log.d("Acolo", e.message)
            emptyList()
        } catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            Log.d("Acolo", e.message)
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            Log.d("Acolo", e.toString())
            emptyList()
        }
    }
}