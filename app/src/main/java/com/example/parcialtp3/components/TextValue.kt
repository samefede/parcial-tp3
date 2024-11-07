package com.example.parcialtp3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray900
import com.example.parcialtp3.ui.theme.TextBaseBold
import com.example.parcialtp3.ui.theme.TextBaseRegular
import com.example.parcialtp3.ui.theme.White2

@Composable
fun TextValue( label: String, value: String) {
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.onSecondaryContainer)) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.tertiary,
            style = TextBaseRegular,
        )
        Text(
            text = value,
            color = MaterialTheme.colorScheme.surface,
            style = TextBaseBold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
@Preview
fun PreviewCardLabel() {
    TextValue(label = "Tarjeta No: ", value = "6061 3580 2384 9041")
}