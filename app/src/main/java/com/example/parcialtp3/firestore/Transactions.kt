package com.example.parcialtp3.firestore

data class Transactions(
    val creditCardTransactions: List<Transaction> = emptyList(),
    val bankAccountTransactions: List<Transaction> = emptyList()
)
