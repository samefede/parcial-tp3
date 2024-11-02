package com.example.parcialtp3.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.screens.signIn.SignInViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.components.CustomButton
import com.example.parcialtp3.components.CustomRadioButton
import com.example.parcialtp3.components.Input
import com.example.parcialtp3.components.Logo
import com.example.parcialtp3.firestore.Wallet
import com.example.parcialtp3.firestore.WalletViewModel
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.Green800
import com.example.parcialtp3.ui.theme.Purple900
import com.example.parcialtp3.ui.theme.TextBaseBold
import com.example.parcialtp3.ui.theme.TextXS1Bold

@Composable
//@Preview
fun SignIn(
    navigationAction: MainNavAction,
    modifier: Modifier = Modifier,
) {
    val viewModel: SignInViewModel = viewModel()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginResponse by remember { mutableStateOf<String?>(null) }
    val walletViewModel: WalletViewModel = viewModel()

    LaunchedEffect(Unit) {
        walletViewModel.fetchWallet()
    }

    val walletState by walletViewModel.wallet.observeAsState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Green800)
    ){
        Logo()

        Column(modifier = Modifier.fillMaxHeight()) {
            Spacer(modifier = Modifier.weight(1f)) // This will take up the top half of the screen
            Box(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .background(Gray100)
                    .padding(horizontal = 12.dp, vertical = 24.dp)
            ) {
                Column(modifier = modifier) {
                    Text(
                        text = "Ingresa a tu cuenta:",
                        style = TextBaseBold,
                        color = Black,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Input(inputName = "DNI o E-mail", inputType = "text", onTextChange = { username = it })
                    Input(inputName = "Contraseña", inputType = "password", onTextChange = { password = it })

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(text = "Olvidé mi contraseña", color = Purple900, style = TextXS1Bold)
                    }


                    CustomRadioButton(text = "Recordar datos de ingreso")

                    CustomButton(text = "Ingresar", onClick = {
                        viewModel.signIn(username, password) { response ->
                            loginResponse = response?.token ?: "Login failed"
                            Log.d("SignIn", "Response: $loginResponse")
                        }
                    })
                    loginResponse?.let {
                        navigationAction.navigateToHome()
                    }
                }
            }
        }
    }




        // Display wallet data
        /*walletState?.let { wallets ->
            LazyColumn {
                items(wallets.size) { index ->
                    val wallet = wallets[index]
                    Text(
                        text = wallet.toString(), // Adjust this line based on your Wallet data class
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red),
                        fontSize = 20.sp
                    )
                }
            }
        }*/
}
