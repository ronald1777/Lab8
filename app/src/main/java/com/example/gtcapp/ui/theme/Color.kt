package com.example.gtcapp.ui.theme

import androidx.compose.ui.graphics.Color

// Colores primarios de GTCApp
val Primary = Color(0xFF08579E)
val Secondary = Color(0xFFDA1931) 
val Accent = Color(0xFFFAB020)

// Fondos
val BackgroundLight = Color(0xFFF4F4F4)
val BackgroundDark = Color(0xFF121212)
val SurfaceLight = Color(0xFFFFFFFF)
val SurfaceDark = Color(0xFF1E1E1E)
val TextLight = Color(0xFF1F2937)
val TextDark = Color(0xFFF3F4F6)
val TextSecondaryLight = Color(0xFF6B7280)
val TextSecondaryDark = Color(0xFF9CA3AF)

// Modo claro
val LightColorScheme = androidx.compose.material3.lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Secondary,
    onSecondary = Color.White,
    tertiary = Accent,
    onTertiary = Color.Black,
    background = BackgroundLight,
    onBackground = TextLight,
    surface = SurfaceLight,
    onSurface = TextLight,
    surfaceVariant = Color(0xFFF5F5F5),
    onSurfaceVariant = TextSecondaryLight,
    outline = Color(0xFFE5E7EB)
)

val DarkColorScheme = androidx.compose.material3.darkColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Secondary,
    onSecondary = Color.White,
    tertiary = Accent,
    onTertiary = Color.Black,
    background = BackgroundDark,
    onBackground = TextDark,
    surface = SurfaceDark,
    onSurface = TextDark,
    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = TextSecondaryDark,
    outline = Color(0xFF374151)
)
