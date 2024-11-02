package com.example.parcialtp3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.screens.account.AccountRoute
import com.example.parcialtp3.screens.credit.CreditRoute
import com.example.parcialtp3.screens.home.HomeRoute
import com.example.parcialtp3.screens.profile.ProfileRoute
import com.example.parcialtp3.screens.services.ServiceRoute
import com.example.parcialtp3.screens.signIn.SignInRoute

@Composable
fun MainRouteNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.SIGN_IN_ROUTE,
    navigationActions: MainNavAction
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = AppDestinations.HOME_ROUTE) {
            HomeRoute(navActions = navigationActions)
        }

        composable(route = AppDestinations.ACCOUNT_ROUTE) {
           AccountRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.CREDIT_ROUTE){
            CreditRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.PROFILE_ROUTE){
            ProfileRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.SERVICE_ROUTE){
            ServiceRoute(navigationAction = navigationActions)
        }

        composable(route = AppDestinations.SIGN_IN_ROUTE){
            SignInRoute(navigationAction = navigationActions)
        }
    }
}