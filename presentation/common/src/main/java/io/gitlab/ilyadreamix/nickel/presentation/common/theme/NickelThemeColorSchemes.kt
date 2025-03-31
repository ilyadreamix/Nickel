package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal val NickelDefaultLightColorScheme = lightColorScheme(
    background = Color.White,
    primary = Color.Black,
    onPrimary = Color.White,
    outline = Color(0xFFAFAFAF),
)

internal val NickelDefaultDarkColorScheme = darkColorScheme(
    background = Color.Black,
    primary = Color.White,
    onPrimary = Color.Black,
    outline = Color(0xFF505050),
)
