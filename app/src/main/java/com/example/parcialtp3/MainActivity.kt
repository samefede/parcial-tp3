package com.example.parcialtp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3.components.Input
import com.example.parcialtp3.components.LinkItem
import com.example.parcialtp3.components.MovementRow
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.screens.SignIn
import com.example.parcialtp3.ui.theme.ParcialTP3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialTP3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        innerPadding
                        //LinkItem("Quiero mi tarjeta física", "", isFirst = true, isLast = false)
                        //MovementRow(date = "19-03-20", description = "Transferencia", transactionId = "394991", type = "credit")
                        //Input(inputName = "DNI o E-mail", inputType = "text", icon = 0, onTextChange = {})
                        //Input(inputName = "Contraseña", inputType = "password", onTextChange = {})
                        SignIn()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParcialTP3Theme {
        Greeting("Android")
    }
}