package com.example.parcialtp3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.Gray500
import com.example.parcialtp3.ui.theme.Gray900
import com.example.parcialtp3.ui.theme.Purple900
import com.example.parcialtp3.ui.theme.Red900
import com.example.parcialtp3.ui.theme.TextBaseRegular
import com.example.parcialtp3.ui.theme.TextXS1Bold
import com.example.parcialtp3.ui.theme.TextXS1Regular
import com.example.parcialtp3.ui.theme.White2

@Composable
fun Input(inputName: String, inputType: String, onTextChange: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(inputType !== "password") }
    var isClickedInput by remember { mutableStateOf(false) }
    val shape = RoundedCornerShape(3.dp)
    var error by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    fun validateInput(input: String): Boolean {
        return when (inputType) {
            "number" -> input.all { it.isDigit() }
            "text" -> input.length >= 8
            "password" -> input.length >= 6
            else -> true
        }
    }

    fun generateTextError(): String {
        return when (inputType) {
            "number" -> "El campo debe ser un número"
            "text" -> "El campo debe tener al menos 8 caracteres"
            "password" -> "El campo debe tener al menos 6 caracteres"
            else -> ""
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(shape)
                .background(White2)
                .border(1.dp, if (error) Red900 else if (isClickedInput) Purple900 else Gray500, shape)
                .clickable {
                    if (!isClickedInput || text.isNotEmpty()) isClickedInput = true
                }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (!isClickedInput) {
                    Text(
                        text = inputName,
                        style = TextXS1Regular,
                        color = Black,
                    )
                } else {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            text = inputName,
                            style = TextXS1Regular,
                            color = Gray900,
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .offset(y = if (isClickedInput || text.isNotEmpty()) (-5).dp else 0.dp)
                                .background(White2)
                        )
                        BasicTextField(
                            value = text,
                            textStyle = TextBaseRegular,
                            maxLines = 1,
                            onValueChange = {
                                if (validateInput(it)) {
                                    text = it
                                    onTextChange(it)
                                    error = false
                                } else {
                                    text = it
                                    onTextChange(it)
                                    error = true
                                    errorMessage = generateTextError()
                                }
                            },
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row() {
                    if (error) {
                        Image(
                            painter = painterResource(id = R.drawable.warning),
                            contentDescription = "Warning",
                        )
                    }
                    if (inputType == "password") {
                        Image(
                            painter = painterResource(id = if (isPasswordVisible) R.drawable.notshow else R.drawable.show),
                            contentDescription = "Hide/Show Password",
                            modifier = Modifier
                                .clickable { isPasswordVisible = !isPasswordVisible }
                        )
                    }
                }
            }
        }
    if (error) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.Bottom
        ){
            Text(
                text = errorMessage,
                color = Red900,
                style = TextXS1Bold,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
  }
}

@Composable
@Preview
fun InputPreview(){
    var savedText by remember { mutableStateOf("") }

    Input(inputName = "DNI o E-mail", inputType = "text", onTextChange = { newText ->
        savedText = newText})
}