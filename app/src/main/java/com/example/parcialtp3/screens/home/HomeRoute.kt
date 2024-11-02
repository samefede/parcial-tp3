package com.example.parcialtp3.screens.home

import androidx.compose.runtime.Composable
import com.example.parcialtp3.navigation.MainNavAction

@Composable
fun HomeRoute(
    navigationAction: MainNavAction
){
    HomeScreen(navigationAction = navigationAction)
}