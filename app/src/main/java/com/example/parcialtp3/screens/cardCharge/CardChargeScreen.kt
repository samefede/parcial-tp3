package com.example.parcialtp3.screens.cardCharge

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.components.CardInfo
import com.example.parcialtp3.components.CustomButton
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.TextXL1Bold

@Composable
fun CardChargeScreen(
    navigationAction: MainNavAction
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Verificá que la información sea\ncorrecta:",
                color = Black,
                style = TextXL1Bold,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(0.7f))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(47.dp)
        ) {


            CardInfo(cardNumber = "6061 3580 2384 9041", amount = "$ 200,00")
        }

        Spacer(modifier = Modifier.weight(0.7f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            CustomButton(
                text = "Continuar",
                onClick = {
                    val au = MediaPlayer.create(context, R.raw.success)
                    au.start()
                    navigationAction.navigateToOperationSuccessfully()
                },

            )
        }
    }
}