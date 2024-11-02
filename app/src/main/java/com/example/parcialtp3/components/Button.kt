package com.example.parcialtp3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Purple900
import com.example.parcialtp3.ui.theme.Shapes
import com.example.parcialtp3.ui.theme.TextBaseBold
import com.example.parcialtp3.ui.theme.White2

@Composable
fun CustomButton(text: String, onClick: () -> Unit){
    Column() {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                ,
            shape = Shapes.extraLarge,
            colors = ButtonDefaults
                .buttonColors(
                    contentColor = White2,
                    containerColor = Purple900,
                )
        ) {
            Text(
                text = text.replaceFirstChar { it.uppercase() },
                style = TextBaseBold
            )
        }
    }
}

@Preview
@Composable
fun ButtonPreview(){
    CustomButton("ingresar", onClick = { println("clickeado") })
}