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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.components.BottomBar
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.navigation.MainRouteNav
import com.example.parcialtp3.screens.SignIn
import com.example.parcialtp3.ui.theme.ParcialTP3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialTP3Theme {

                val navController = rememberNavController()
                val navigationActions = MainNavAction(navController)

                val shouldHideBottomBar = navigationActions.hideBottomBar(
                    navController.currentBackStackEntry?.destination?.route
                )
                
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if(!shouldHideBottomBar){
                            BottomBar(navigationActions = navigationActions)
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        MainRouteNav(
                            navController = navController,
                            navigationActions = navigationActions
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