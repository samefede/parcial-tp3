package com.example.parcialtp3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Green800
import com.example.parcialtp3.ui.theme.Shapes
import com.example.parcialtp3.ui.theme.TextXS1Regular
import com.example.parcialtp3.ui.theme.White2

@Composable
fun CustomCheckbox(text: String) {
    var checkedState by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White2),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (checkedState) Green800 else White2,
                    shape = CircleShape
                )

        ){
            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it},

            )
        }
        
        Text(
            text = text.replaceFirstChar {  it.uppercase() },
            style = TextXS1Regular
        )
    }
}

@Preview
@Composable
fun CheckboxColors() {
    CustomCheckbox("Recordar datos de ingreso")
}