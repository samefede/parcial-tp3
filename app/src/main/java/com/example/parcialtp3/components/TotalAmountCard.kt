package com.example.parcialtp3.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Elevation
import com.example.parcialtp3.ui.theme.Shapes
import com.example.parcialtp3.ui.theme.TextXS1Bold
import com.example.parcialtp3.ui.theme.TextXS1Regular

@Composable
fun TotalAmountCard(amount: Double, cvu: String) {

    val clipboardManager = LocalClipboardManager.current

    Card(
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(Elevation),
        shape = Shapes.medium,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSecondaryContainer)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onSecondaryContainer)
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Text(
                        text = "CVU: ",
                        color = MaterialTheme.colorScheme.tertiary,
                        style = TextXS1Regular,
                    )
                    Text(
                        text = cvu,
                        color = MaterialTheme.colorScheme.surface,
                        style = TextXS1Bold,
                        textAlign = TextAlign.Center,
                    )
                }

                Text(
                    text = "Copiar",
                    style = TextXS1Bold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clickable {
                        clipboardManager.setText(AnnotatedString(cvu))
                    }
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