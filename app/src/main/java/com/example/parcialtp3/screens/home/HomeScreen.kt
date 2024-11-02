package com.example.parcialtp3.screens.home
import ActionCard
import AlertCustom
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.R
import com.example.parcialtp3.components.Card
import com.example.parcialtp3.components.TextSize
import com.example.parcialtp3.components.TotalAmount
import com.example.parcialtp3.firestore.WalletViewModel
import com.example.parcialtp3.navigation.MainNavAction
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.TextXL1Bold
import com.example.parcialtp3.ui.theme.TextXS2Regular

@Composable
fun HomeScreen(
    navigationAction: MainNavAction,
    modifier: Modifier = Modifier
){
    val walletViewModel: WalletViewModel = viewModel()

    LaunchedEffect(Unit) {
        walletViewModel.fetchWallet()
    }

    val walletState by walletViewModel.wallet.observeAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(12.dp)
    ) {
        item {
            Card("4957 1234 12345 5824")

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            walletState?.get(0)?.let {
                TotalAmount(amount = it.balance, textSize = TextSize.BIG)
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            AlertCustom(
                alertText = "La cuota de tu préstamo está próxima a vencer.",
                linkText = "Ver préstamo"
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth().height(96.dp)) {
                    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                        item {
                            ActionCard(iconResId = R.drawable.cargardinero, textLine1 = "Cargar", textLine2 = "Dinero", topLeftCornerRadius = 8.dp)
                        }
                        item {
                            ActionCard(iconResId = R.drawable.extraerdinero, textLine1 = "Extraer", textLine2 = "Dinero")
                        }
                        item {
                            ActionCard(iconResId = R.drawable.prestamos, textLine1 = "Seguir", textLine2 = "Mi Préstamo", topRightCornerRadius = 8.dp)
                        }
                    }
                }

                Row(modifier = Modifier.fillMaxWidth().height(96.dp)){
                    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                        item {
                            ActionCard(iconResId = R.drawable.recargasube, textLine1 = "Recarga", textLine2 = "Sube", bottomLeftCornerRadius = 8.dp)
                        }
                        item {
                            ActionCard(iconResId = R.drawable.recargacelu, textLine1 = "Recarga", textLine2 = "Celular")
                        }
                        item {
                            ActionCard(iconResId = R.drawable.pagoservicio, textLine1 = "Pagar", textLine2 = "Servicio", bottomRightCornerRadius = 8.dp)
                        }
                    }
                }
            }
        }
    }
}