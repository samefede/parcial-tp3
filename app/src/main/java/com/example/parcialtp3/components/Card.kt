package com.example.parcialtp3.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.theme.Green800
import androidx.compose.ui.res.painterResource
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Purple900
import com.example.parcialtp3.ui.theme.TextXL2Bold
import com.example.parcialtp3.ui.theme.TextXS1Bold

@Composable
fun Card(cardNumber: String){

    val isShowingFullNumber = remember { mutableStateOf(false) }

    val maskedCardNumber = cardNumber.replaceRange(5, 15, "**** *****")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
        
    ) {
        Box(
            modifier = Modifier
//            .fillMaxWidth()
                .width(336.dp)
                .height(212.dp)
                .background(Green800, shape = RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp))
        ){

            Image(
                painter = painterResource(id = R.drawable.bkg),
                contentDescription = "Triangulo",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(26.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.End)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.waynimovil),
                        contentDescription = "Logo App",
                        modifier = Modifier
//                            .size(40.dp)
                            .height(28.09.dp)
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                ){
                    Column() {
                        Text(
                            text = if (isShowingFullNumber.value) cardNumber else maskedCardNumber,
                            color = Color.White,
                            style = TextXL2Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "05/23",
                            color = Color.White,
                            style = TextXL2Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logomastercard),
                        contentDescription = "MasterCard",
                        modifier = Modifier
//                            .size(40.dp)
                            .height(34.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .clickable { isShowingFullNumber.value = !isShowingFullNumber.value },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ojito),
                contentDescription = "Ojo",
                modifier = Modifier
//                            .size(40.dp)
                    .height(34.dp)
            )
            Text(
                text = if (isShowingFullNumber.value) "Ocultar datos" else "Mostrar datos",
                color = Purple900,
                modifier = Modifier
                    .padding(start = 8.dp),
                style = TextXS1Bold
            )

        }
    }

}


//Box(
//modifier = Modifier
//.drawWithCache {
//    val triangleSize = 530.dp.toPx()
//    val roundedPolygon = RoundedPolygon(
//        numVertices = 3,
//        radius = triangleSize / 2,
//        centerX = size.width / 2 - 75.dp.toPx(),
//        centerY = size.height / 2 + 70.dp.toPx(),
//        rounding = CornerRounding(
//            size.minDimension / 5f,
//            smoothing = 0.1f
//        )
//    )
//    val roundedPolygonPath = roundedPolygon
//        .toPath()
//        .asComposePath()
//    onDrawBehind {
//        drawPath(roundedPolygonPath, color = Green900)
//    }
//}
//.size(530.dp)
//)


@Preview(showBackground = true)
@Composable
fun PreviewMyCard() {
    Card("4957 1234 12345 5824")
}