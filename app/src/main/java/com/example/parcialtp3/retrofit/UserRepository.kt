package com.example.parcialtp3.retrofit

class UserRepository {
    private val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)

    suspend fun get(): UserResponse {
        return apiService.getUser()
    }
}