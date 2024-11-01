package com.example.parcialtp3.retrofit

class LoginRepository {
    private val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)

    suspend fun login(username: String, password: String): LoginResponse {
        val loginDTO = LoginDTO(username, password)
        return apiService.login(loginDTO)
    }
}