package com.example.parcialtp3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Elevation
import com.example.parcialtp3.ui.theme.Purple900
import com.example.parcialtp3.ui.theme.Shapes
import com.example.parcialtp3.ui.theme.TextXS1Bold
import com.example.parcialtp3.ui.theme.White2

@Composable
fun TotalAmountCard(amount: Double, cvu: String) {
    Card(
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(Elevation),
        shape = Shapes.medium
    ) {
        Column(
            modifier = Modifier
                .background(White2)
                .padding(24.dp)
        ) {
            TotalAmount(amount, TextSize.SMALL)

            HorizontalDivider(
                modifier = Modifier
                    .padding(8.dp),
                thickness = 1.dp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextValue(
                    label = "CVU: ",
                    value = "0000654326538129540653"
                )

                Text(
                    text = "Copiar",
                    style = TextXS1Bold,
                    color = Purple900
                )
            }
        }
    }
}

@Composable
@Preview
fun TotalAmountCardPreview() {
    TotalAmountCard(1322.78,"0000654326538129540653")
}