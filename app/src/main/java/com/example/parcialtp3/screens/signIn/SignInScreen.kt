package com.example.parcialtp3.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.screens.signIn.SignInViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.R
import com.example.parcialtp3.components.CustomButton
import com.example.parcialtp3.components.CustomRadioButton
import com.example.parcialtp3.components.ErrorModal
import com.example.parcialtp3.components.Input
import com.example.parcialtp3.components.Logo
import com.example.parcialtp3.firestore.Wallet
import com.example.parcialtp3.firestore.WalletViewModel
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.Green800
import com.example.parcialtp3.ui.theme.Green900
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

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Green800)
    ){

        Column(modifier = Modifier.fillMaxHeight()) {

                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Column (
                        modifier = Modifier
                            .height(153.5.dp)
                            .width(288.dp),
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Logo()
                        //40.dp o 25.dp
                        Spacer(modifier = Modifier.size(25.dp))

                        Image(
                            painter = painterResource(id = R.drawable.dialogtriangle),
                            contentDescription = "Una billetera"
                        )

                        Row(){

                            Image(
                                painter = painterResource(id = R.drawable.unabilletera),
                                contentDescription = "Una billetera"
                            )

                            Spacer(modifier = Modifier.size(4.dp))

                            Box(
                                modifier = Modifier
                                    .size(56.dp, 36.dp)
                                    .clip(RoundedCornerShape(100.dp))
                                    .background(Green900),
                                contentAlignment = Alignment.Center
                            ){
                                Image(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.drawable.smiling_face_with_smiling_eyes),
                                    contentDescription = "Simple Para Vos."
                                )
                            }
                        }

                        Spacer(modifier = Modifier.size(5.dp))
                        Row(){
                            Box(
                                modifier = Modifier
                                    .size(56.dp, 36.dp)
                                    .clip(RoundedCornerShape(100.dp))
                                    .background(Green900),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.drawable.raising_hands),
                                    contentDescription = "Simple Para Vos."
                                )
                            }

                            Spacer(modifier = Modifier.size(4.dp))

                            Image(
                                painter = painterResource(id = R.drawable.simpleparavos),
                                contentDescription = "Simple Para Vos."
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1.2f)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                        .background(Gray100)
                        .padding(horizontal = 12.dp, vertical = 24.dp)
                ) {
                    Column() {
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

                        Spacer(modifier = Modifier.size(24.dp))

                        CustomRadioButton(text = "Recordar datos de ingreso")

                        Spacer(modifier = Modifier.size(24.dp))

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            CustomButton(text = "Ingresar", onClick = {
                                viewModel.signIn(username, password) { response ->
                                    loginResponse = response?.token ?: "Error en Login"
                                    Log.d("SignIn", "Response: $loginResponse")
                                }
                            })
                        }
                        LaunchedEffect(loginResponse) {
                            loginResponse?.let {
                                if (it != "Error en Login") {
                                    navigationAction.navigateToHome()
                                }
                            }
                        }
                    }
                }
            }

        ErrorModal(isVisible = loginResponse == "Error en Login", loginResponse?: "") {
            loginResponse = null
        }
    }
}

