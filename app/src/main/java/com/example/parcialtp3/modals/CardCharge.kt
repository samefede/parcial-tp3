package com.example.parcialtp3.modals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Gray100


@Composable
@Preview
fun CardCharge() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(horizontal = 12.dp)
    ) {
        Text(text = "Cargar Tarjeta", modifier = Modifier.padding(vertical = 16.dp))
    }
}
