package com.example.parcialtp3.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray500
import com.example.parcialtp3.ui.theme.TextXS2Bold

@Composable
fun ServiceCard(iconResId: Int, serviceText: String) {
    Box(
        modifier = Modifier
            .padding(top = 4.dp)
            .fillMaxWidth()
            .widthIn(min = 160.dp)
            .height(138.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(8.dp))
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, Gray500), shape = RoundedCornerShape(8.dp))
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(min = 90.dp)
                .height(138.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.size(64.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.borde),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = serviceText,
                style = TextXS2Bold,
                color = Black,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
@Preview
fun PreviewServiceCard() {
    ServiceCard(
        iconResId = R.drawable.pagoservicio,
        serviceText = "PAGO DE SERVICIOS"
    )
}