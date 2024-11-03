package com.example.parcialtp3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.TextXL4
import com.example.parcialtp3.ui.theme.TextXL5
import com.example.parcialtp3.ui.theme.TextXS2Bold
import java.text.NumberFormat
import java.util.Locale

enum class TextSize {
    BIG, SMALL
}

@Composable
fun TotalAmount(amount: Double, textSize: TextSize) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Saldo disponible".uppercase(),
            style = TextXS2Bold,
            color = Black,
        )
        Text(
            text = formatAmountToCash(amount),
            style = when (textSize) {
                TextSize.SMALL -> TextXL4
                TextSize.BIG -> TextXL5
            },
            color = Black
        )
    }
}

fun formatAmountToCash(amount: Double): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("es", "AR"))
    return formatter.format(amount)
}

@Composable
@Preview
fun TotalAmountPreview() {
    TotalAmount(amount = 1234.56, textSize = TextSize.SMALL)
}
