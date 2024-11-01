package com.example.parcialtp3.retrofit

import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun login(loginDTO: LoginDTO): LoginResponse
}