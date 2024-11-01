package com.example.parcialtp3.retrofit

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginDTO: LoginDTO): LoginResponse
}