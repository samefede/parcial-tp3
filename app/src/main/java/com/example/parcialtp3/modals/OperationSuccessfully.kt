package com.example.parcialtp3.modals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.components.CustomButton
import com.example.parcialtp3.ui.theme.Gray100
import com.example.partialtp3.components.SuccessMessage

@Composable
fun OperationSuccessfully() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(horizontal = 12.dp)
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
        ) {
            SuccessMessage()
        }

        Column(
            modifier = Modifier.align(Alignment.BottomEnd),
        ) {
            CustomButton(
                text = "Continuar"
            ) {
                // accion
            }
        }
    }
}

@Composable
@Preview
fun OperationSuccessfullyPreview() {
    OperationSuccessfully()
}
