package com.example.parcialtp3.firestore

data class Transaction(
    val transactionId: String = "",
    val date: String = "",
    val description: String = "",
    val amount: Double = 0.0,
    val currency: String =  "",
    val type: String = ""
)
