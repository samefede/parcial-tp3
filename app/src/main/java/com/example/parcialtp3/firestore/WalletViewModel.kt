package com.example.parcialtp3.firestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class WalletViewModel : ViewModel() {
    private val _wallet = MutableLiveData<List<Wallet>>()
    val wallet: LiveData<List<Wallet>> = _wallet
    private val firebaseFireStore = FirebaseFirestore.getInstance()
    private val walletCollection = firebaseFireStore.collection("wallet")

    fun fetchWallet() {
        walletCollection.get().addOnSuccessListener { result ->
            val walletList = mutableListOf<Wallet>()
            for (document in result) {
                val wallet = document.toObject(Wallet::class.java)
                walletList.add(wallet)
            }

            if(walletList.isNotEmpty()){
                _wallet.value = walletList
            }
        }
    }
}