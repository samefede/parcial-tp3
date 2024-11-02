import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.theme.Red900
import com.example.parcialtp3.ui.theme.TextXS2Bold
import com.example.parcialtp3.ui.theme.TextXS2Regular

@Composable
fun AlertCustom(
    modifier: Modifier = Modifier,
    alertText: String,
    linkText: String
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Red900)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Column for the alert text and link text
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = alertText.replaceFirstChar { it.uppercase() },
                    color = Color.White,
                    style = TextXS2Regular
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = linkText.replaceFirstChar { it.uppercase() },
                    color = Color.White,
                    style = TextXS2Bold
                )
            }

            // Icon aligned to the right
            Image(
                painter = painterResource(id = R.drawable.next),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
@Preview
fun AlertCustomPreview() {
    AlertCustom(
        alertText = "La cuota de tu préstamo está próxima a vencer.",
        linkText = "Ver préstamo"
    )
}
