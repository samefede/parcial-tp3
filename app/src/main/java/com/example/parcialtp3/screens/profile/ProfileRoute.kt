package com.example.parcialtp3.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun ProfileRoute(
    isDarkTheme: MutableState<Boolean>
){
    ProfileScreen(isDarkTheme = isDarkTheme)
}