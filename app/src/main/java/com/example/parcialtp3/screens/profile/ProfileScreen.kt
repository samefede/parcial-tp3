package com.example.parcialtp3.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.parcialtp3.navigation.MainNavAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.components.LinkItem
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.TextXL2Bold


@Composable
fun ProfileScreen(
    navigationAction: MainNavAction,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile photo",
                modifier = Modifier.size(120.dp, 120.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "\uD83D\uDC4B Hola Mariana Belén",
                style = TextXL2Bold,
                color = Black,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(buttonName = "Mis datos", description = "", isFirst = true, isLast = false)
            LinkItem(modifier = Modifier.offset(y = (-1).dp), buttonName = "Mi CVU", "", isFirst = false, isLast = false)
            LinkItem(modifier = Modifier.offset(y = (-2).dp), buttonName = "Configuración", "", isFirst = false, isLast = false)
            LinkItem(modifier = Modifier.offset(y = (-3).dp), buttonName = "Ayuda", "", isFirst = false, isLast = false)
            LinkItem(modifier = Modifier.offset(y = (-4).dp), buttonName = "Términos y condiciones", "", isFirst = false, isLast = false)
            LinkItem(modifier = Modifier.offset(y = (-5).dp), buttonName = "Cerrar sesión", "", isFirst = false, isLast = true)

            Spacer(modifier = Modifier.size(40.dp))

            LinkItem(buttonName = "Dark Mode", description = "", isFirst = true, isLast = true)

            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}