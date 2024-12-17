package com.example.car_sellingapp.data.remote

import com.example.car_sellingapp.data.remote.dto.GetUsersResponse
import com.example.car_sellingapp.data.remote.dto.PostRequest
import com.example.car_sellingapp.data.remote.dto.PostResponse
import com.example.myapplication.data.remote.PostsService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PostsServiceImpl(
    private val client: HttpClient
) : PostsService {
    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get { url(HttpRoutes.POSTS) }.body<List<PostResponse>>()
        } catch (e: RedirectResponseException){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch (e: ClientRequestException){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch (e: ServerResponseException){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch (e: Exception){
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try{
            client.post {
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
            }.body<PostResponse>()
        }catch (e: RedirectResponseException){
            println("Error: ${e.response.status.description}")
            null
        }catch (e: ClientRequestException){
            println("Error: ${e.response.status.description}")
            null
        }catch (e: ServerResponseException){
            println("Error: ${e.response.status.description}")
            null
        }catch (e: Exception){
            println("Error: ${e.message}")
            null
        }
    }

    override suspend fun getUsers(): List<GetUsersResponse> {
        return try {
            client.get { url(HttpRoutes.GET_USERS) }.body<List<GetUsersResponse>>()
        } catch (e: RedirectResponseException){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch (e: ClientRequestException){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch (e: ServerResponseException){
            println("Error: ${e.response.status.description}")
            emptyList()
        }catch (e: Exception){
            println("Error: ${e.message}")
            emptyList()
        }
    }
}