package com.example.parcialtp3.screens

import android.util.Log
import androidx.compose.animation.core.Animatable
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.screens.signIn.SignInViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.R
import com.example.parcialtp3.components.CustomButton
import com.example.parcialtp3.components.CustomRadioButton
import com.example.parcialtp3.components.ErrorModal
import com.example.parcialtp3.components.Input
import com.example.parcialtp3.components.LinkItem
import com.example.parcialtp3.components.Logo
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.Purple900
import com.example.parcialtp3.ui.theme.TextBaseBold
import com.example.parcialtp3.ui.theme.TextXS1Bold
import kotlinx.coroutines.delay

@Composable
//@Preview
fun SignIn(
    navigationAction: MainNavAction,
    modifier: Modifier = Modifier
) {
    val viewModel: SignInViewModel = viewModel()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginResponse by remember { mutableStateOf<String?>(null) }

    val offsetY = remember { Animatable(400f) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.onSecondary)
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
                            .height(180.5.dp) //153.5
                            .width(288.dp),
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Logo() //40.dp o 25.dp

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Column (modifier = Modifier.fillMaxHeight()){
                                Row() {
                                    Image(
                                        modifier = Modifier.offset(y = (4).dp, x = (34).dp),
                                        painter = painterResource(id = R.drawable.dialogtriangle),
                                        contentDescription = "Dialog triangle"
                                    )
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.unabilletera),
                                        contentDescription = "Una billetera"
                                    )

                                    Spacer(modifier = Modifier.size(4.dp))

                                    Box(
                                        modifier = Modifier
                                            .size(56.dp, 36.dp)
                                            .clip(RoundedCornerShape(100.dp))
                                            .background(MaterialTheme.colorScheme.tertiaryContainer),
                                        contentAlignment = Alignment.Center
                                    ){
                                        Image(
                                            modifier = Modifier.size(24.dp),
                                            painter = painterResource(id = R.drawable.smiling_face_with_smiling_eyes),
                                            contentDescription = "Smiling face."
                                        )
                                    }
                                }

                            }



                        }

                        Spacer(modifier = Modifier.size(5.dp))
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp), horizontalArrangement = Arrangement.Start){
                            Box(
                                modifier = Modifier
                                    .size(56.dp, 36.dp)
                                    .clip(RoundedCornerShape(100.dp))
                                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.drawable.raising_hands),
                                    contentDescription = "Raising hands."
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

            LaunchedEffect(Unit) {
                delay(500) // Espera 2 segundos
                offsetY.animateTo(targetValue = 0f) // Ajusta el valor según necesites
            }
                Box(
                    modifier = Modifier
                        .weight(1.2f)
                        .fillMaxWidth()
                        .offset(y = offsetY.value.dp)
                        .shadow(20.dp, RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                        .background(MaterialTheme.colorScheme.background)

                        .padding(horizontal = 12.dp, vertical = 24.dp)

                ) {
                    Column() {
                        Text(
                            text = "Ingresa a tu cuenta:",
                            style = TextBaseBold,
                            color = MaterialTheme.colorScheme.surface,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Input(inputName = "DNI o E-mail", inputType = "text", onTextChange = { username = it })
                        Input(inputName = "Contraseña", inputType = "password", onTextChange = { password = it })

                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = "Olvidé mi contraseña", color = MaterialTheme.colorScheme.secondary, style = TextXS1Bold)
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

