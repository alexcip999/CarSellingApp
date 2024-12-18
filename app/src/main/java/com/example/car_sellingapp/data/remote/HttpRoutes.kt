package com.example.car_sellingapp.data.remote

object HttpRoutes {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val POSTS = "$BASE_URL/posts"

    const val GET_USERS = "http://192.168.1.102:8080/users"
    const val LOGIN = "http://192.168.1.102:8080/auth/login"
}