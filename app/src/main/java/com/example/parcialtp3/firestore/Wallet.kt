package com.example.parcialtp3.firestore

data class Wallet(
    val userId: String = "",
    val balance: Double = 0.0,
    val bankAccount: BankAccount = BankAccount(bankName = "", accountType = "", cvu = "", alias = "", currency = ""),
    val transactions: Transactions = Transactions(creditCardTransactions = emptyList(), bankAccountTransactions = emptyList())
)
