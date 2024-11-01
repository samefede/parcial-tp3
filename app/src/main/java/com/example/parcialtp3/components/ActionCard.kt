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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.parcialtp3.ui.theme.Black

@Composable
fun ActionCard(
    modifier: Modifier = Modifier,
    iconResId: Int,
    textLine1: String,
    textLine2: String,
    topLeftCornerRadius: Dp = 0.dp, // Radio para la esquina superior izquierda
    topRightCornerRadius: Dp = 0.dp, // Radio para la esquina superior derecha
    bottomCornerRadius: Dp = 0.dp // Radio para las esquinas inferiores
) {
    val shape = RoundedCornerShape(
        topStart = topLeftCornerRadius,
        topEnd = topRightCornerRadius,
        bottomStart = bottomCornerRadius,
        bottomEnd = bottomCornerRadius
    )

    Card(
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .size(width = 112.dp, height = 96.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFD1D1D7),
                shape = shape
            )
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
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = textLine1.uppercase(),
                color = Black,
                style = TextStyle(fontSize = 14.sp)
            )
            Text(
                text = textLine2.uppercase(),
                color = Black,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}
