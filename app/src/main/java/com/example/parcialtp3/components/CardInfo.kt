package com.example.parcialtp3.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray500
import com.example.parcialtp3.ui.theme.TextXL4

@Composable
fun CardInfo(cardNumber: String, amount: String) {
    Box(
        modifier = Modifier
            .size(width = 336.dp, height = 249.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(8.dp))
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, Gray500), shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.sube_logo),
                contentDescription = null,
                modifier = Modifier.size(140.dp, 80.dp)
            )

            BorderSpacing()

            TextValue(label = "Tarjeta Nº: ", value = cardNumber)

            BorderSpacing()

            Text(
                text = amount,
                color = Black,
                style = TextXL4,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview
fun PreviewCardInfo() {
    CardInfo(cardNumber = "6061 3580 2384 9041", amount = "$ 200,00")
}