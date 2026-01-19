package com.example.mycityandroidstudiocourses.ui.theme


import androidx.compose.material3.Typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycityandroidstudiocourses.R

val GoogleSans = FontFamily(
    Font(R.font.googlesans_bold),
    Font(R.font.googlesans_italic),
    Font(R.font.googlesans_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = GoogleSans,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = GoogleSans,
        fontStyle = FontStyle.Italic,
        fontSize = 10.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = GoogleSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
    )

)