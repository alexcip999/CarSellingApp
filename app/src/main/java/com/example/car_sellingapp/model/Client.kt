package com.example.car_sellingapp.model


import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Client {
    private val client = HttpClient()

    suspend fun register(registerRequest: RegisterRequest): HttpResponse {
        return client.post("http://10.0.2.2:8080/auth/register"){
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(registerRequest))
        }
    }
}


@Serializable
class RegisterRequest(
    val username: String,
    val password: String,
    val passwordConfirmation: String
)