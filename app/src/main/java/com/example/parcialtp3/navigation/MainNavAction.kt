package com.example.parcialtp3.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.TextXL1Bold
import com.example.parcialtp3.ui.theme.White

object AppDestinations{
    const val SIGN_IN_ROUTE = "signin"
    const val HOME_ROUTE = "home"
    const val ACCOUNT_ROUTE = "acount"
    const val CREDIT_ROUTE = "credit"
    const val PROFILE_ROUTE = "profile"
    const val SERVICE_ROUTE = "services"
    const val SPLASH_ROUTE = "splash"
    const val CARD_CHARGE_ROUTE = "cardCharge"
    const val OPERATION_SUCCESSFULLY_ROUTE = "operationSuccessfully"
}

val hideBottomBar= listOf(
    AppDestinations.SIGN_IN_ROUTE,
    AppDestinations.SPLASH_ROUTE,
    AppDestinations.CARD_CHARGE_ROUTE,
    AppDestinations.OPERATION_SUCCESSFULLY_ROUTE
)

val hideTopBar= listOf(
    AppDestinations.SIGN_IN_ROUTE,
    AppDestinations.SPLASH_ROUTE,
)

class MainNavAction(
    navController: NavHostController,
){
    val navigateToHome: () -> Unit = {
        navController.navigate(AppDestinations.HOME_ROUTE) {
            popUpTo(AppDestinations.SIGN_IN_ROUTE) { inclusive = true }
            launchSingleTop = true
        }
    }
    val navigateToAccount: () -> Unit = {
        navController.navigate(AppDestinations.ACCOUNT_ROUTE)
    }
    val navigateToCredit: () -> Unit = {
        navController.navigate(AppDestinations.CREDIT_ROUTE)
    }
    val navigateToProfile: () -> Unit = {
        navController.navigate(AppDestinations.PROFILE_ROUTE)
    }
    val navigateToService: () -> Unit = {
        navController.navigate(AppDestinations.SERVICE_ROUTE)
    }
    val navigateToSignIn: () -> Unit = {
        navController.navigate(AppDestinations.SIGN_IN_ROUTE) {
            popUpTo(AppDestinations.SPLASH_ROUTE) { inclusive = true }
            launchSingleTop = true
        }
    }
    val navigateToCardCharge: () -> Unit = {
        navController.navigate(AppDestinations.CARD_CHARGE_ROUTE)
    }
    val navigateToOperationSuccessfully: () -> Unit = {
        navController.navigate(AppDestinations.OPERATION_SUCCESSFULLY_ROUTE)
    }

    fun hideBottomBar(location: String?): Boolean{
        return hideBottomBar.contains(location)
    }

    fun hideTopBar(location: String?): Boolean{
        return hideTopBar.contains(location)
    }

    fun getColorTopBar(location: String?): Color{
        return when(location){
            AppDestinations.HOME_ROUTE -> Gray100
            AppDestinations.ACCOUNT_ROUTE -> Gray100
            AppDestinations.CREDIT_ROUTE -> Gray100
            AppDestinations.PROFILE_ROUTE -> Gray100
            AppDestinations.SERVICE_ROUTE -> Gray100
            AppDestinations.CARD_CHARGE_ROUTE -> White
            else -> Color.White
        }
    }

    fun getTextTopBar(location: String?): String{
        return when(location){
            AppDestinations.HOME_ROUTE -> "\uD83D\uDC4B Hola Mariana"
            AppDestinations.ACCOUNT_ROUTE -> "Mi Cuenta"
            AppDestinations.CREDIT_ROUTE -> "Mi Tarjeta"
            AppDestinations.PROFILE_ROUTE -> "Mi perfil"
            AppDestinations.SERVICE_ROUTE -> "Pago de servicios"
            AppDestinations.CARD_CHARGE_ROUTE -> "Cargar SUBE"
            else -> ""
        }
    }

    fun getTitleStyleTopBar(location: String?): TextStyle{
        return when(location){
            AppDestinations.HOME_ROUTE -> TextXL1Bold
            AppDestinations.ACCOUNT_ROUTE -> TextXL1Bold
            AppDestinations.CREDIT_ROUTE -> TextXL1Bold
            AppDestinations.PROFILE_ROUTE -> TextXL1Bold
            AppDestinations.SERVICE_ROUTE -> TextXL1Bold
            AppDestinations.CARD_CHARGE_ROUTE -> TextXL1Bold
            else -> TextXL1Bold
        }
    }

    fun getTitleColorTopBar(location: String?): Color{
        return when(location){
            AppDestinations.HOME_ROUTE -> Black
            AppDestinations.ACCOUNT_ROUTE -> Black
            AppDestinations.CREDIT_ROUTE -> Black
            AppDestinations.PROFILE_ROUTE -> Black
            AppDestinations.SERVICE_ROUTE -> Black
            AppDestinations.CARD_CHARGE_ROUTE -> Black
            else -> Black
        }
    }

    fun getDescriptionTopBar(location: String?): String{
        return when(location){
            AppDestinations.HOME_ROUTE -> "Ultimo acceso: Mar 01, 2020 4:55 PM"
            AppDestinations.ACCOUNT_ROUTE -> ""
            AppDestinations.CREDIT_ROUTE -> ""
            AppDestinations.PROFILE_ROUTE -> ""
            AppDestinations.SERVICE_ROUTE -> ""
            AppDestinations.CARD_CHARGE_ROUTE -> ""
            else -> ""
        }
    }
}