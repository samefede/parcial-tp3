package com.example.parcialtp3.screens.cardCharge

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.components.CardInfo
import com.example.parcialtp3.components.CustomButton
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.TextXL1Bold
import com.example.parcialtp3.R

@Composable
fun CardChargeScreen(
    navigationAction: MainNavAction
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(start = 12.dp, end = 12.dp, top = 0.dp, bottom = 16.dp)
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(47.dp)
        ) {

            Box(modifier = Modifier.width(336.dp)) {
                Text(
                    text = "Verificá que la información sea correcta:",
                    color = Black,
                    style = TextXL1Bold,
                    textAlign = TextAlign.Center
                )
            }

            CardInfo(cardNumber = "6061 3580 2384 9041", amount = "$ 200,00")
        }

        Column(
            modifier = Modifier.align(Alignment.BottomEnd),
        ) {
            CustomButton(
                text = "Continuar",
                onClick = {
                    val au = MediaPlayer.create(context, R.raw.success)
                    au.start()
                    navigationAction.navigateToOperationSuccessfully()
                }
            )
        }
    }
}