package com.example.myapplication.data.remote

import com.example.car_sellingapp.data.remote.PostsServiceImpl
import com.example.car_sellingapp.data.remote.dto.GetUsersRequest
import com.example.car_sellingapp.data.remote.dto.GetUsersResponse
import com.example.car_sellingapp.data.remote.dto.PostRequest
import com.example.car_sellingapp.data.remote.dto.PostResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json


interface PostsService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?

    suspend fun getUsers(): List<GetUsersResponse>

    companion object {
        fun create(): PostsService{
            return PostsServiceImpl(
                client = HttpClient(Android){
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(ContentNegotiation){
                        json()
                    }
                }
            )
        }
    }
}