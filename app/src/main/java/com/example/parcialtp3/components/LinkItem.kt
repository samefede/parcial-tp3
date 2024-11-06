package com.example.parcialtp3.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray500
import com.example.parcialtp3.ui.theme.Gray900
import com.example.parcialtp3.ui.theme.TextBaseBold
import com.example.parcialtp3.ui.theme.TextXS1Regular
import com.example.parcialtp3.ui.theme.White2

@Composable
fun LinkItem(
            buttonName: String,
             description: String = "",
             isFirst: Boolean = false,
             isLast: Boolean = false,
             isSwitch: Boolean = false,
             switched: Boolean = false,
             onSwitchedChange: (Boolean) -> Unit
) {
    val descriptionEmpty = description.isEmpty()
    val shape = when {
        isFirst && isLast -> RoundedCornerShape(8.dp)
        isFirst -> RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
        isLast -> RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
        else -> RoundedCornerShape(0.dp)
    }

    var isClicked by remember { mutableStateOf(false) }

    var isSwitched by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (descriptionEmpty) 56.dp else 74.13.dp)
            .clip(shape)
            .background(White2)
            .border(1.dp, Gray500, shape)
            .clickable { isClicked = !isClicked }
            .padding(horizontal = 12.dp, vertical = if (descriptionEmpty) 8.dp else 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row (
            modifier = Modifier.height( if(descriptionEmpty) 24.dp else 42.13.dp ),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ){
            Column (
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ){
                Text(text = buttonName, style = TextBaseBold, color = Black )
                if (!descriptionEmpty) {
                    Text(text = description, style = TextXS1Regular, color = Gray900)
                }
            }

            Column (modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = if (descriptionEmpty) Arrangement.Center else Arrangement.Top

            ) {
                if(isSwitch){
                    Switch(checked = switched, onCheckedChange = onSwitchedChange )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.btn),
                        contentDescription = "Boton"
                    )
                }
            }
        }
    }
}


@Composable
@Preview
fun LinkItemPreview() {
    //LinkItem("Quiero mi tarjeta física", "", isFirst = true, isLast = false)
    //LinkItem("Ya tengo mi tarjeta física", "Activa tu tarjeta para comenzar a usarla", isFirst = false, isLast = true)
}