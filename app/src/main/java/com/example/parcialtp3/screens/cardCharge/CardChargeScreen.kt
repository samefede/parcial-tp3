package com.example.parcialtp3.screens.cardCharge

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
    ) {
        // Custom Top Bar
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color.White)
                .shadow(1.dp)
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navigationAction.navigateToService }
            )

            Spacer(modifier = Modifier.width(115.dp))

            Text(
                text = "Cargar Sube",
                color = Black,
                style = TextXL1Bold,
                modifier = Modifier.weight(1f)
            )

            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = "Close",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navigationAction.navigateToService }
            )
        }

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


        // Spacer to push content to the center
        Spacer(modifier = Modifier.weight(0.7f))

        // Centered Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(47.dp)
        ) {


            CardInfo(cardNumber = "6061 3580 2384 9041", amount = "$ 200,00")
        }

        // Spacer to push the button to the bottom
        Spacer(modifier = Modifier.weight(0.7f))

        // Button at the bottom
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