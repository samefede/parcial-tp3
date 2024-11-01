package com.example.parcialtp3.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3.screens.signIn.SignInViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun SignIn(modifier: Modifier = Modifier) {
    val viewModel: SignInViewModel = viewModel()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginResponse by remember { mutableStateOf<String?>(null) }

    Column(modifier = modifier) {
        BasicTextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
        )
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
        )
        Button(onClick = {
            viewModel.signIn(username, password) { response ->
                loginResponse = response?.token ?: "Login failed"
                Log.d("SignIn", "Response: $loginResponse")
            }
        }) {
            Text("Login")
        }
        loginResponse?.let {
            Text(text = it)
        }
    }
}