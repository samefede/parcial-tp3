package com.example.parcialtp3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R

@Composable
fun Logo() {
    Row(
        modifier = Modifier.width(257.dp)
            .padding(bottom = 25.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.waynimovil),
            contentDescription = "Wayni Movil"
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.union),
            contentDescription = "Union",
            modifier = Modifier.align(Alignment.Bottom)

        )
    }
}

@Composable
@Preview
fun LogoPreview() {
    Logo()
}
