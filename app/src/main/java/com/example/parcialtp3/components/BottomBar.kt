package com.example.parcialtp3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.navigation.BottomNavItem
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Green800

@Composable
fun BottomBar(
    navigationActions: MainNavAction,
){

    var selectedItem by remember { mutableIntStateOf(0) }
    val navItems = listOf(
        BottomNavItem(R.drawable.home, R.drawable.homev, navigationActions.navigateToHome),
        BottomNavItem(R.drawable.movimientos, R.drawable.movimientosv, navigationActions.navigateToAccount),
        BottomNavItem(R.drawable.tarjetacredito, R.drawable.tarjetacreditov, navigationActions.navigateToCredit),
        BottomNavItem(R.drawable.wallet, R.drawable.walletv, navigationActions.navigateToService),
        BottomNavItem(R.drawable.menu, R.drawable.menuv, navigationActions.navigateToProfile)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .shadow(8.dp)
            .height(80.dp)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    item.action()
                },
                modifier = Modifier
                    .fillMaxHeight(),
                icon = {
                    Box (
                        modifier = Modifier
                            .fillMaxHeight()
                        ,
                        contentAlignment = Alignment.Center,
                    ){
                        if(selectedItem == index){
                            Box(
                                modifier = Modifier
                                    .width(64.dp)
                                    .height(2.dp)
                                    .background(MaterialTheme.colorScheme.onSurfaceVariant)
                                    .align(Alignment.TopCenter)
                            )
                        }
                        Image(
                            painter = painterResource(if (selectedItem == index) item.selectedImage else item.image),
                            contentDescription = "Nav Icon",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp)
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Unspecified,
                    unselectedIconColor = Color.Unspecified,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

