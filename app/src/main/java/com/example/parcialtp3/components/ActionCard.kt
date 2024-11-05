import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.parcialtp3.ui.theme.Black
import com.example.parcialtp3.ui.theme.TextXS2Bold

@Composable
fun ActionCard(
    modifier: Modifier = Modifier,
    iconResId: Int,
    textLine1: String,
    textLine2: String,
    topLeftCornerRadius: Dp = 0.dp, // Radio para la esquina superior izquierda
    topRightCornerRadius: Dp = 0.dp, // Radio para la esquina superior derecha
    bottomRightCornerRadius: Dp = 0.dp, // Radio para la esquina inferior derecha
    bottomLeftCornerRadius: Dp = 0.dp,   // Radio para la esquina inferior izquierda
    onClick: () -> Unit = {} // Acción a realizar al hacer clic
) {
    //variable shape que contendra los radios para aplicar tanto a la card como al box
    val shape = RoundedCornerShape(
        topStart = topLeftCornerRadius,
        topEnd = topRightCornerRadius,
        bottomStart = bottomLeftCornerRadius,
        bottomEnd = bottomRightCornerRadius
    )

    Card(
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        //elevation = CardDefaults.cardElevation(Elevation),
        modifier = modifier
            .fillMaxWidth().height(96.dp) //130 110
            .border(
                width = 0.6.dp,
                color = Color(0xFFD1D1D7),
                shape = shape,

            ),
        onClick = { onClick() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(24.dp).width(22.dp).height(20.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = textLine1.uppercase(),
                color = Black,
                style = TextXS2Bold
            )
            Text(
                text = textLine2.uppercase(),
                color = Black,
                style = TextXS2Bold
            )
        }
    }
}
