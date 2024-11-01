package com.example.parcialtp3.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R

val ManropeFontFamily = FontFamily(
    Font(R.font.manrope_medium, FontWeight.Medium),
    Font(R.font.manrope_bold, FontWeight.Bold),
    Font(R.font.manrope_regular, FontWeight.Normal),
    Font(R.font.manrope_light, FontWeight.Light),
    Font(R.font.manrope_extralight, FontWeight.ExtraLight),
    Font(R.font.manrope_extrabold, FontWeight.ExtraBold),
    Font(R.font.manrope_semibold, FontWeight.SemiBold)
)

/* BaseFontSize = 16.sp */

/*
100	FontWeight.Thin
200	FontWeight.ExtraLight
300	FontWeight.Light
400	FontWeight.Normal
500	FontWeight.Medium
600	FontWeight.Semibold
700	FontWeight.Bold
800	FontWeight.ExtraBold
900	FontWeight.Black
*/

/* MOBILE TEXT */

// Last Access - Alert Message
val TextXS2Regular = TextStyle(
    fontFamily = ManropeFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 14.4.sp
)

// Action Button Text, Service Button Text
val TextXS2Bold = TextStyle(
    fontFamily = ManropeFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 14.4.sp
)

// Form Placeholder, Label - Checkbox Text - Promotional Text
val TextXS1Regular = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 14.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 19.6.sp,
)

// Button Text - Button Text + Icon - Button Medium Fill - Grid Label Text - Error, Forgot, Seen messages
val TextXS1Bold = TextStyle(
    fontFamily = ManropeFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 19.6.sp
)

// General Text - Input Text, Select Text - SUBE Credit Number
val TextBaseRegular = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 22.4.sp,
)

// Button - Button Big, Outline - Button Big + Icon (Right, Left), Fill - Link Item Text
val TextBaseBold = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 22.4.sp,
)

val TextXL1Regular = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 18.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 21.6.sp,
)

/* MOBILE HEADERS*/

// Hello Message, My Account Title, SUBE General Title
val TextXL1Bold = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 21.6.sp,
)

val TextXL2Regular = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 20.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 24.sp,
)

// Credit Card - Account Hello Message
val TextXL2Bold = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

val TextXL3Regular = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 24.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = 26.4.sp,
)

val TextXL3Bold = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 26.4.sp,
)

/* DESKTOP & LARGE MOBILE HEADER */

// SUBE Total Amount
val TextXL4 = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 35.2.sp,
)

// Total Balance
val TextXL5 = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 44.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 48.4.sp,
    letterSpacing = (-0.16).sp
)

val TextXL6 = TextStyle(
    fontFamily = ManropeFontFamily,
    fontSize = 74.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 74.sp,
    letterSpacing = (-0.32).sp
)