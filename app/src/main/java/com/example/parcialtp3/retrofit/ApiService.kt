package com.example.parcialtp3.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(@Body loginDTO: LoginDTO): LoginResponse

    @GET("users/1")
    suspend fun getUser(): UserResponse
}