package com.example.parcialtp3.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.screens.account.AccountRoute
import com.example.parcialtp3.screens.cardCharge.CardChargeRoute
import com.example.parcialtp3.screens.credit.CreditRoute
import com.example.parcialtp3.screens.home.HomeRoute
import com.example.parcialtp3.screens.operationSuccessfully.OperationSuccessfullyRoute
import com.example.parcialtp3.screens.profile.ProfileRoute
import com.example.parcialtp3.screens.services.ServiceRoute
import com.example.parcialtp3.screens.signIn.SignInRoute
import com.example.parcialtp3.splash.SplashRoute

@Composable
fun MainRouteNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.SPLASH_ROUTE,
    navigationActions: MainNavAction
) {

    val enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
        slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(durationMillis = 250, easing = LinearOutSlowInEasing)
        )
    }

    val exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
        slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = tween(durationMillis = 200, easing = LinearOutSlowInEasing)
        )
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = AppDestinations.SPLASH_ROUTE) {
            SplashRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.HOME_ROUTE) {
            HomeRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.ACCOUNT_ROUTE) {
           AccountRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.CREDIT_ROUTE){
            CreditRoute(navigationAction = navigationActions)
        }

        composable(
            route = AppDestinations.PROFILE_ROUTE,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
        ){
            ProfileRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.SERVICE_ROUTE){
            ServiceRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.SIGN_IN_ROUTE){
            SignInRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.CARD_CHARGE_ROUTE){
            CardChargeRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.OPERATION_SUCCESSFULLY_ROUTE){
            OperationSuccessfullyRoute(navigationAction = navigationActions)
        }
    }
}