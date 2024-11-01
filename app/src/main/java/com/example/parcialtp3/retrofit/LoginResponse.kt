package com.example.parcialtp3.retrofit

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token") val token: String,
) {
    fun toLoginResponse(): LoginResponse {
        return LoginResponse(token)
    }
}
