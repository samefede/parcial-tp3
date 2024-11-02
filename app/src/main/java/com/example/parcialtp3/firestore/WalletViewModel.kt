package com.example.parcialtp3.firestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class WalletViewModel : ViewModel() {
    private val _wallet = MutableLiveData<List<Wallet>>()
    val wallet: LiveData<List<Wallet>> = _wallet
    private val firebaseFireStore = FirebaseFirestore.getInstance()
    private val walletCollection = firebaseFireStore.collection("wallet")

    suspend fun fetchWallet() {
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

    /*suspend fun fetchUsers(): List<Wallet> {
        val db = FirebaseFirestore.getInstance()
        return try {
            val result = db.collection("wallet") // Cambia "users" por el nombre de tu colección
                .get()
                .await()

            result.documents.map { document ->
                document.toObject(Wallet::class.java)!!.copy(id = document.id)
            }
        } catch (e: Exception) {
            emptyList() // Maneja errores o retorna una lista vacía en caso de error
        }
    }*/
    /*fun addTransaction(transaction: Transaction) {
        walletCollection.add(transaction).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                fetchWallet()
            }
        }
    }*/
}