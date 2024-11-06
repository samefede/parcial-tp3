package com.example.parcialtp3.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.parcialtp3.navigation.MainNavAction

@Composable
fun ProfileRoute(
    navigationAction: MainNavAction, isDarkTheme: MutableState<Boolean>
){
    ProfileScreen(isDarkTheme = isDarkTheme)
}