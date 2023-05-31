package com.example.sahabatmakara.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sahabatmakara.R

// Set of Material typography styles to start with

val rubikFontFamily = FontFamily(
    fonts = listOf(
        Font(R.font.rubik_light, FontWeight.Light),
        Font(R.font.rubik_regular, FontWeight.Normal),
        Font(R.font.rubik_medium, FontWeight.Medium),
        Font(R.font.rubik_semibold, FontWeight.SemiBold),
        Font(R.font.rubik_bold, FontWeight.Bold),
        Font(R.font.rubik_extrabold, FontWeight.ExtraBold),
        Font(R.font.rubik_black, FontWeight.Black),
    )
)

val typography = Typography(
    // Headline 1
    headlineLarge = TextStyle(
        fontFamily = rubikFontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = (19.2).sp
    ),
    // Headline 2
    headlineMedium = TextStyle(
        fontFamily = rubikFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = (18.8).sp
    ),
    // Headline 3
    headlineSmall = TextStyle(
        fontFamily = rubikFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = (14.4).sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)