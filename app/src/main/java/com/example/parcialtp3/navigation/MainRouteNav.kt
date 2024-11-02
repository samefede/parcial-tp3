package com.example.parcialtp3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.screens.credit.AccountRoute
import com.example.parcialtp3.screens.home.HomeRoute

@Composable
fun MainRouteNavGraph(
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


    }
}