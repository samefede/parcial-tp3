package com.example.parcialtp3.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.screens.signIn.SignInViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.components.Input
import com.example.parcialtp3.firestore.Wallet
import com.example.parcialtp3.firestore.WalletViewModel
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Purple900
import com.example.parcialtp3.ui.theme.TextBaseBold

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

    Column(modifier = modifier) {
        Input(inputName = "DNI o E-mail", inputType = "number", onTextChange = { username = it })
        Input(inputName = "Contraseña", inputType = "password", onTextChange = { password = it })

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Purple900),
            onClick = {
            viewModel.signIn(username, password) { response ->
                loginResponse = response?.token ?: "Login failed"
                Log.d("SignIn", "Response: $loginResponse")

                /*val allWallet = walletViewModel.wallet.observeAsState()
                allWallet.value?.let { wallets ->
                    LazyColumn {
                        items(wallets.size) { wallet ->
                            Text(
                                text = wallet.content, modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Red),
                                fontSize = 20.sp
                            )
                        }
                    }
                }*/
            }
        }) {
            Text("Ingresar", style = TextBaseBold)
        }
        loginResponse?.let {
            Text(text = it)
        }

        // Display wallet data
        walletState?.let { wallets ->
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
        }
    }
}