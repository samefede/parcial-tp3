package com.example.parcialtp3.navigation

import android.widget.MediaController
import androidx.navigation.NavHostController

object AppDestinations{
    const val SIGN_IN_ROUTE = "signin"
    const val HOME_ROUTE = "home"
    const val ACCOUNT_ROUTE = "acount"
    const val CREDIT_ROUTE = "credit"
    const val PROFILE_ROUTE = "profile"
    const val SERVICE_ROUTE = "services"
    const val SPLASH_ROUTE = "splash"
}

val hideBottomBar= listOf(
    AppDestinations.SIGN_IN_ROUTE,
    AppDestinations.SPLASH_ROUTE,
)

class MainNavAction(
    navController: NavHostController,
){
    val navigateToHome: () -> Unit = {
        navController.navigate(AppDestinations.HOME_ROUTE)
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
        navController.navigate(AppDestinations.SIGN_IN_ROUTE)
    }

    fun hideBottomBar(location: String?): Boolean{
        return hideBottomBar.contains(location)
    }
}