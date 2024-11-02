package com.example.parcialtp3.screens.services

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.parcialtp3.navigation.MainNavAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.components.ServiceCard
import com.example.parcialtp3.ui.theme.Gray100

@Composable
fun ServiceScreen(
    navigationAction: MainNavAction,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(horizontal = 12.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            item {
                ServiceCard(iconResId = R.drawable.recargasube, serviceText = "RECARGA SUBE")
            }
            item {
                ServiceCard(iconResId = R.drawable.recargacelu, serviceText = "RECARGA CELULAR")
            }
            item {
                ServiceCard(iconResId = R.drawable.pagoservicio, serviceText = "PAGO DE SERVICIOS")
            }
            item {
                ServiceCard(iconResId = R.drawable.directtv, serviceText = "DIRECT TV PREPAGO")
            }
        }

    }
}