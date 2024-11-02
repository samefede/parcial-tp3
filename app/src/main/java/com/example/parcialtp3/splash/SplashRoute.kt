package com.example.parcialtp3.splash

import androidx.compose.runtime.Composable
import com.example.parcialtp3.navigation.MainNavAction

@Composable
fun SplashRoute (
    navigationAction: MainNavAction
){
    SplashScreen(navigationAction)
}