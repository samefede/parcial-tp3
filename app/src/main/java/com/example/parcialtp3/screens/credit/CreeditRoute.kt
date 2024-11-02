package com.example.parcialtp3.screens.credit

import androidx.compose.runtime.Composable
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.screens.account.AccountScreen

@Composable
fun AccountRoute(
    navigationAction: MainNavAction,
){
    AccountScreen(navigationAction = navigationAction)
}