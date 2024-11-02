package com.example.parcialtp3.components

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.navigation.BottomNavItem
import com.example.parcialtp3.navigation.MainNavAction

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
        containerColor = Color.White,
        modifier = Modifier
            .shadow(8.dp) //fijarse
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    item.action()
                },
                icon = {
                    Image(
                        painter = painterResource(if (selectedItem == index) item.selectedImage else item.image),
                        contentDescription = "ups"
                    )
                }
            )
        }
    }
}

