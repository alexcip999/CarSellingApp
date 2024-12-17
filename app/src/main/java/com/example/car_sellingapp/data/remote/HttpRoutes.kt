package com.example.car_sellingapp.data.remote

object HttpRoutes {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val POSTS = "$BASE_URL/posts"

    private const val MY_BASE_URL = "http://10.0.2.2:8080"
    const val GET_USERS = "$MY_BASE_URL/users"
}