package com.example.parcialtp3.screens.signIn

import androidx.compose.runtime.Composable
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.screens.SignIn

@Composable
fun SignInRoute(
    navigationAction: MainNavAction
){
    SignIn(navigationAction)
}