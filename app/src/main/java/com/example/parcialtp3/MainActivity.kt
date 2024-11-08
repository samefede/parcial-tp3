package com.example.parcialtp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.components.BottomBar
import com.example.parcialtp3.components.NavigationTopBar
import com.example.parcialtp3.components.TopBar
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.navigation.MainRouteNav
import com.example.parcialtp3.ui.theme.ParcialTP3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkTheme = remember { mutableStateOf(false) }
            ParcialTP3Theme (darkTheme = isDarkTheme.value){
                var lastScreen: String? = ""

                val navController = rememberNavController()
                val navigationActions = MainNavAction(navController)

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        val currentLocation = navController.currentBackStackEntryAsState().value?.destination?.route

                        if(!navigationActions.hideTopBar(currentLocation)) {
                            if(navigationActions.getNavigationTopBar(currentLocation)) {
                                NavigationTopBar(
                                    onClick = { navController.popBackStack() },
                                    quitScreen = { navController.navigate(lastScreen.toString())} ,
                                    topBarColor = navigationActions.getColorTopBar(currentLocation),
                                    title = navigationActions.getTextTopBar(currentLocation),
                                    titleStyle = navigationActions.getTitleStyleTopBar(currentLocation),
                                    titleColor = navigationActions.getTitleColorTopBar(currentLocation),
                                )
                            } else {
                                lastScreen = currentLocation
                                TopBar(
                                    topBarColor = navigationActions.getColorTopBar(currentLocation),
                                    title = navigationActions.getTextTopBar(currentLocation),
                                    titleStyle = navigationActions.getTitleStyleTopBar(currentLocation),
                                    titleColor = navigationActions.getTitleColorTopBar(currentLocation),
                                    description = navigationActions.getDescriptionTopBar(currentLocation)
                                )
                            }
                        }
                    },
                    bottomBar = {
                        val currentLocation = navController.currentBackStackEntryAsState().value?.destination?.route
                        if (!navigationActions.hideBottomBar(currentLocation)) {
                            BottomBar(navigationActions = navigationActions)
                        }
                    },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        MainRouteNav(
                            navController = navController,
                            navigationActions = navigationActions,
                            isDarkTheme = isDarkTheme
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParcialTP3Theme {
        Greeting("Android")
    }
}