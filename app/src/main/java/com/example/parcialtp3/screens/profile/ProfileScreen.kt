package com.example.parcialtp3.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcialtp3.R
import com.example.parcialtp3.components.LinkItem
import com.example.parcialtp3.ui.theme.TextXL2Bold
import com.example.parcialtp3.navigation.AppDestinations

@Composable
fun ProfileScreen(
    navController: NavController,
    isDarkTheme: MutableState<Boolean>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile photo",
                modifier = Modifier.size(120.dp, 120.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "\uD83D\uDC4B Hola Mariana Belén",
                style = TextXL2Bold,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(buttonName = "Mis datos", isFirst = true)
            LinkItem(buttonName = "Mi CVU")
            LinkItem(buttonName = "Configuración")
            LinkItem(buttonName = "Ayuda")
            LinkItem(buttonName = "Términos y condiciones")
            LinkItem(
                buttonName = "Cerrar sesión",
                isLast = true,
                onLogout = {
                    navController.navigate(AppDestinations.SIGN_IN_ROUTE) {
                        popUpTo(AppDestinations.HOME_ROUTE) { inclusive = true }
                    }
                }
            )

            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(buttonName = "Dark Mode", "", isFirst = true, isLast = true, isSwitch = true, switched = isDarkTheme.value, onSwitchedChange = {
                isDarkTheme.value = !isDarkTheme.value
            })

            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}