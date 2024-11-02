package com.example.parcialtp3.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray500
import com.example.parcialtp3.ui.theme.TextXS2Bold

@Composable
fun ServiceCard(iconResId: Int, serviceText: String) {
    Surface(
        modifier = Modifier
            .size(width = 160.dp, height = 138.dp)
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(8.dp), clip = false),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Gray500),
    ) {
        Column(
            modifier = Modifier
                .size(width = 116.dp, height = 94.dp),
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
                maxLines = 1
            )
        }
    }
}

@Composable
@Preview
fun PreviewServiceCard() {
    ServiceCard(iconResId = R.drawable.pagoservicio, serviceText = "PAGO DE SERVICIOS")
}