package com.example.parcialtp3.screens.operationSuccessfully

import androidx.compose.runtime.Composable
import com.example.parcialtp3.modals.OperationSuccessfullyScreen
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.screens.cardCharge.CardChargeScreen

@Composable
fun OperationSuccessfullyRoute(
    navigationAction: MainNavAction
){
    OperationSuccessfullyScreen(navigationAction = navigationAction)
}
