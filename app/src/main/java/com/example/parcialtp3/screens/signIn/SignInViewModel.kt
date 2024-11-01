package com.example.parcialtp3.screens.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.retrofit.LoginRepository
import com.example.parcialtp3.retrofit.LoginResponse
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    private val repository = LoginRepository()

    fun signIn(username: String, password: String, onResult: (LoginResponse?) -> Unit) {
        viewModelScope.launch {
            try {
                Log.d("SignIn", "Trying to login with username: $username and password: $password")
                //username: "mor_2314",
                //password: "83r5^_"
                val response = repository.login(username, password)
                onResult(response)
            } catch (e: Exception) {
                Log.e("SignIn", "Error while trying to login", e)
                onResult(null)
            }
        }
    }
}