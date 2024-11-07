package com.example.parcialtp3.screens.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.components.ServiceCard
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceScreen(
    navigationAction: MainNavAction? = null
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                    serviceText = "RECARGA SUBE",
                    onClick = {
                        navigationAction?.navigateToCardCharge?.let { it() }
                    }
                )
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