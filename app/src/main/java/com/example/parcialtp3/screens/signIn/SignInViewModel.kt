package com.example.parcialtp3.screens.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.retrofit.LoginRepository
import com.example.parcialtp3.retrofit.LoginResponse
import com.example.parcialtp3.retrofit.UserRepository
import com.example.parcialtp3.retrofit.UserResponse
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    private val loginRepository = LoginRepository()
    private val userRepository = UserRepository()

    fun signIn(username: String, password: String, onResult: (LoginResponse?) -> Unit) {
        viewModelScope.launch {
            try {
                Log.d("SignIn", "Trying to login with username: $username and password: $password")
                val response = loginRepository.login(username,  password)
                onResult(response)
            } catch (e: Exception) {
                Log.e("SignIn", "Error while trying to login", e)
                onResult(null)
            }
        }
    }

    fun fetchUser(onResult: (UserResponse?) -> Unit) {
        viewModelScope.launch {
            try {
                val user = userRepository.get()
                onResult(user)
            } catch (e: Exception) {
                Log.e("User", "Error while trying to fetch user", e)
                onResult(null)
            }
        }
    }
}