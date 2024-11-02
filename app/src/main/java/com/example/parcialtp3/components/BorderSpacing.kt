package com.example.parcialtp3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Gray500

@Composable
fun BorderSpacing() {
    Box(
        modifier = Modifier
            .padding(vertical = 15.dp)
            .width(288.dp)
            .height(1.dp)
            .background(Gray500)
    )
}

@Composable
@Preview
fun PreviewBorderSpacing() {
    BorderSpacing()
}
