package com.example.parcialtp3.screens.account
import ActionCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.R
import com.example.parcialtp3.components.MovementRow
import com.example.parcialtp3.components.TotalAmountCard
import com.example.parcialtp3.firestore.Transaction
import com.example.parcialtp3.firestore.WalletViewModel
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.TextXS1Bold

@Composable
fun AccountScreen() {
    val walletViewModel: WalletViewModel = viewModel()

    LaunchedEffect(Unit) {
        walletViewModel.fetchWallet()
    }

    val walletState by walletViewModel.wallet.observeAsState()
    val bankAccountTransactions: List<Transaction>? = walletState?.get(0)?.transactions?.bankAccountTransactions
    val creditCardTransaction: List<Transaction>? = walletState?.get(0)?.transactions?.creditCardTransactions
    val allTransactions: List<Transaction> = (bankAccountTransactions ?: emptyList()) +
                                             (creditCardTransaction ?: emptyList())
    val sortedTransactions = allTransactions.sortedByDescending { it.date }

    println("walletState: $walletState")
    println("Bank Account Transactions: $bankAccountTransactions")
    Column(
        modifier = Modifier
            .background(Gray100),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 12.dp),
        ){
            walletState?.get(0)?.let { TotalAmountCard(amount = it.balance, cvu = it.bankAccount.cvu) }

            Spacer(modifier = Modifier.height(25.dp))

            Row {
                LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                    item {
                        ActionCard(iconResId = R.drawable.cargardinero , textLine1 = "CARGAR", textLine2 = "DINERO", topLeftCornerRadius = 8.dp, bottomLeftCornerRadius = 8.dp)

                    }
                    item {
                        ActionCard(iconResId = R.drawable.extraerdinero , textLine1 = "EXTRAER", textLine2 = "DINERO")

                    }
                    item {
                        ActionCard(iconResId = R.drawable.transferencia , textLine1 = "TRANSFERIR", textLine2 = "DINERO", topRightCornerRadius = 8.dp, bottomRightCornerRadius = 8.dp)
                    }
                }
            }

        }


        Spacer(modifier = Modifier.height(25.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Black)
                .fillMaxWidth()
                .height(35.dp)
        ) {
            Text(text = "MOVIMIENTOS", style = TextXS1Bold, color = Color.White, modifier = Modifier.padding(start = 10.dp))


        }

        LazyColumn(
            contentPadding = PaddingValues(bottom = 56.dp)
        ) {
            items(sortedTransactions.size) { index ->
                val transaction = sortedTransactions[index]
                walletState?.get(0)?.userId?.let {
                    MovementRow(
                        date = transaction.date,
                        description = transaction.description,
                        transactionId = it,
                        amount = transaction.amount,
                        type = transaction.type
                    )
                }
            }
        }
    }
}


