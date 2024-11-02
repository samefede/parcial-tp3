package com.example.parcialtp3.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray900
import com.example.parcialtp3.ui.theme.TextBaseBold
import com.example.parcialtp3.ui.theme.TextBaseRegular

@Composable
fun TextValue(label: String, value: String) {
    Row {
        Text(
            text = label,
            color = Gray900,
            style = TextBaseRegular
        )
        Text(
            text = value,
            color = Black,
            style = TextBaseBold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun PreviewCardLabel() {
    TextValue(label = "Tarjeta No: ", value = "6061 3580 2384 9041")
}