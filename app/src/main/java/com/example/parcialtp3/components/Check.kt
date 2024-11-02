package com.example.parcialtp3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.TextXS1Regular
import com.example.parcialtp3.ui.theme.White2

@Composable
fun CustomRadioButton(text: String) {
    var checkedState by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White2)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .focusable()
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .clickable {
                isFocused = true
            }
        ,
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    checkedState = !checkedState
                    isFocused = false
                }
                .padding(4.dp)
        ) {
            val icon = when {
                checkedState -> R.drawable.radio_button_success
                isFocused -> R.drawable.radio_button_focus
                else -> R.drawable.radio_button_inactive
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = if (checkedState) "Radio Button Active" else "Radio Button Inactive",
                modifier = Modifier
                    .size(30.dp)
            )
        }

        Text(
            text = text.replaceFirstChar { it.uppercase() },
            style = TextXS1Regular,
            color = Black,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun RadioButtonColors() {
    CustomRadioButton("Recordar datos de ingreso")
}
