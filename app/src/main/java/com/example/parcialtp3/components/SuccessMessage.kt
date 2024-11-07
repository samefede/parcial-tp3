package com.example.partialtp3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.TextXL2Bold

@Composable
fun SuccessMessage() {
    Box {
        Column(
            modifier = Modifier
                .width(300.dp)
                .height(168.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ok),
                contentDescription = "Operación exitosa",
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Tu operación se ha realizado con éxito",
                color = MaterialTheme.colorScheme.surface,
                style = TextXL2Bold,
                textAlign = TextAlign.Center
            )
        }
    }

}

@Composable
@Preview
fun PreviewSuccessMessage() {
    SuccessMessage()
}