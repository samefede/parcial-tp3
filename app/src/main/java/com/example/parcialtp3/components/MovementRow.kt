package com.example.parcialtp3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray500
import com.example.parcialtp3.ui.theme.Green900
import com.example.parcialtp3.ui.theme.Red900
import com.example.parcialtp3.ui.theme.TextXS1Bold
import com.example.parcialtp3.ui.theme.TextXS1Regular
import com.example.parcialtp3.ui.theme.White
import com.example.parcialtp3.ui.theme.White2
import java.util.Locale

@Composable
fun MovementRow(date: String, description: String, transactionId: String, amount: Double = 100.0, type: String) {
    val formattedAmount = String.format(Locale("es", "ES"), "%,.2f", amount).replace('.', ',')
    val amountText = if (type == "credit") "+ $$formattedAmount" else "- $$formattedAmount"
    val amountColor = if (type == "credit") Green900 else Red900

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(White2)
            .border(1.dp, Gray500)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Fecha
            Text(
                text = date,
                style = TextXS1Regular,
                color = Black,
                modifier = Modifier.width(72.dp) //TODO: REVISAR DP
            )

            // Descripción y Autorización
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = description,
                    style = TextXS1Regular,
                    color = Black,
                    maxLines = 1
                )
                Text(
                    text = "Aut. $transactionId",
                    style = TextXS1Regular,
                    color = Black,
                    maxLines = 1
                )

            }
                Text(
                    text = amountText,
                    style = TextXS1Bold,
                    color = amountColor,
                )
        }
    }
}

@Composable
@Preview
fun MovementRowPreview() {
    MovementRow("19-03-20", "Transferencia", "394991", 100.0, "debit")
}