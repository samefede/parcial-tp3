package com.example.parcialtp3.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController

@Composable
fun ProfileRoute(
    isDarkTheme: MutableState<Boolean>,
    navController: NavController
){
    ProfileScreen(isDarkTheme = isDarkTheme, navController = navController)
}