package com.example.parcialtp3.screens.services

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.parcialtp3.navigation.MainNavAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.components.ServiceCard
import com.example.parcialtp3.ui.theme.Gray100
import androidx.compose.ui.text.style.TextAlign
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.TextXL1Bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceScreen(
    navigationAction: MainNavAction? = null
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                ServiceCard(
                    iconResId = R.drawable.recargasube,
                    serviceText = "RECARGA SUBE" )
            }
            item {
                ServiceCard(
                    iconResId = R.drawable.recargacelu,
                    serviceText = "RECARGA CELULAR")
            }
            item {
                ServiceCard(
                    iconResId = R.drawable.pagoservicio,
                    serviceText = "PAGO DE SERVICIOS")
            }
            item {
                ServiceCard(
                    iconResId = R.drawable.directtv,
                    serviceText = "DIRECT TV PREPAGO")
            }
        }
    }
}

@Preview
@Composable
fun PreviewServiceScreen() {
    ServiceScreen()
}