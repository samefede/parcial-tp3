package com.example.parcialtp3.screens.credit

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.parcialtp3.navigation.MainNavAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.components.Card
import com.example.parcialtp3.components.LinkItem
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray100
import com.example.parcialtp3.ui.theme.Gray500
import com.example.parcialtp3.ui.theme.TextXS1Regular
import com.example.parcialtp3.ui.theme.TextXS2Bold

@Composable
fun CreditScreen(
    navigationAction: MainNavAction,
    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(horizontal = 12.dp)
    ) {
        item {
            Text(
                text = "TARJETA VIRTUAL",
                style = TextXS2Bold,
                color = Black,
            )

            Spacer(modifier = Modifier.height(16.dp))
            Card("4957 1234 12345 5824")
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Gray500)
                    .padding(horizontal = 0.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            val textWithIcon = buildAnnotatedString {
                appendInlineContent("icon", "[icon]")
                append(" ¿Sabías que puedes pedir una tarjeta Mastercard física para utilizar directamente en los negocios que elijas?")
            }

            val inlineContent = mapOf(
                "icon" to InlineTextContent(
                    placeholder = Placeholder(
                        width = 19.6.sp,
                        height = 19.6.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lightbulb),
                        contentDescription = "Lamparita"
                    )
                }
            )

            Text(
                text = textWithIcon,
                style = TextXS1Regular,
                color = Black,
                inlineContent = inlineContent
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Column {
                Text(
                    text = "TARJETA FÍSICA",
                    style = TextXS2Bold,
                    color = Black,
                )
                Spacer(modifier = Modifier.height(16.dp))
                LinkItem(buttonName = "Quiero mi tarjeta fisica", isFirst = true)
                LinkItem(buttonName = "Ya tengo mi tarjeta fisica", description="Activa tu tarjeta para comenzar a usarla", isLast = true)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}