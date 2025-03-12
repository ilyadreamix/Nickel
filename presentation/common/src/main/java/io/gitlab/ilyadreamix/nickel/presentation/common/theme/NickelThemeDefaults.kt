package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

internal val NickelDefaultLightColorScheme = NickelColorScheme(
    background = Color.White,
    container = Color(0xFFE3E3E3),
    containerContent = Color.Black,
    outline = Color(0xFFAFAFAF),
    primary = Color.Black,
    primaryContent = Color.White
)

internal val NickelDefaultDarkColorScheme = NickelColorScheme(
    background = Color.Black,
    container = Color(0xFF1C1C1C),
    containerContent = Color.White,
    outline = Color(0xFF505050),
    primary = Color.White,
    primaryContent = Color.Black
)

internal val NickelDefaultSizes = NickelSizes(
    screenPadding = 16.dp,
    containerCornerRadius = 8.dp,
    containerSpacing = 6.dp
)

internal val NickelDefaultShapes = NickelShapes(
    container = RoundedCornerShape(NickelDefaultSizes.containerCornerRadius)
)
