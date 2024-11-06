package com.example.parcialtp3.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

/* COLOR PALETTE */
private val DarkColorScheme = darkColorScheme(
    primary = Black,
    secondary = Green800,
    onSecondary = Purple900,
    onSecondaryContainer = Purple900,
    tertiary = Pink80,
    tertiaryContainer = Purple80,
    background = Black,
    onBackground = Purple80,
    surface = White2,
    surfaceTint = Green900,
    surfaceContainerLow = Green800,
    surfaceContainer = Black,
    surfaceVariant = Gray300,
    surfaceDim = Gray900,
    surfaceBright = Purple900,
    inverseSurface = Purple80,
    errorContainer = Purple900,
    error = White2,
    outline = Purple80
)

private val LightColorScheme = lightColorScheme(
    primary = Green800,
    secondary = Purple900,
    onSecondary = Green800,
    onSecondaryContainer = White2,
    tertiary = Gray900,
    tertiaryContainer = Green900,
    background = Gray100,
    onBackground = Purple900,
    surface = Black,
    surfaceTint = Black,
    surfaceContainerLow = Black,
    surfaceContainer = White2,
    surfaceVariant = White2,
    surfaceDim = Green800,
    surfaceBright = Color(0xFFD1D1D7),
    inverseSurface = White,
    errorContainer = Red900,
    error = White2,
    outline = Gray500
    )

/* BORDER RADIUS */
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

val Elevation = 4.dp

@Composable
fun ParcialTP3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        shapes = Shapes
    )
}