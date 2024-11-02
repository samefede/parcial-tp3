package com.example.parcialtp3.navigation

data class BottomNavItem(
    val image: Int,
    val selectedImage: Int,
    val action: () -> Unit,
)
