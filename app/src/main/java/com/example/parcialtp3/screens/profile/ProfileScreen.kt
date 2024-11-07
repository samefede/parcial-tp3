package com.example.parcialtp3.screens.profile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.parcialtp3.R
import com.example.parcialtp3.components.LinkItem
import com.example.parcialtp3.ui.theme.TextXL2Bold
import com.example.parcialtp3.navigation.AppDestinations
import com.example.parcialtp3.screens.signIn.SignInViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    isDarkTheme: MutableState<Boolean>
){
    val userViewModel: SignInViewModel = viewModel()
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var loginResponse by remember { mutableStateOf<String?>(null) }

    userViewModel.fetchUser { response ->
        loginResponse = response?.let {
            firstName = it.name.firstname
            lastName = it.name.lastname
            "Success"
        } ?: "Error en Login"
        Log.d("SignIn", "Response: $loginResponse")
    }

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
                text = "\uD83D\uDC4B Hola $firstName $lastName",
                style = TextXL2Bold,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(buttonName = "Mis datos", isFirst = true)
            LinkItem(modifier = Modifier.offset(y = (-1).dp), buttonName = "Mi CVU")
            LinkItem(modifier = Modifier.offset(y = (-2).dp), buttonName = "Configuración")
            LinkItem(modifier = Modifier.offset(y = (-3).dp), buttonName = "Ayuda")
            LinkItem(modifier = Modifier.offset(y = (-4).dp), buttonName = "Términos y condiciones")
            LinkItem(
                modifier = Modifier.offset(y = (-5).dp),
                buttonName = "Cerrar sesión",
                isLast = true,
                onLogout = {
                    navController.navigate(AppDestinations.SIGN_IN_ROUTE) {
                        popUpTo(AppDestinations.HOME_ROUTE) { inclusive = true }
                    }
                }
            )

            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(buttonName = "Dark Mode",description = "", isFirst = true, isLast = true, isSwitch = true, switched = isDarkTheme.value, onSwitchedChange = {
                isDarkTheme.value = !isDarkTheme.value
            })

            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}