package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

internal object NickelDarkThemeDefaultColors {
    internal val Background = Color.Black
    internal val Container = Color(0xFF1C1C1C)
    internal val ContainerContent = Color.White
    internal val Outline = Color(0xFF505050)
    internal val Primary = Color.White
    internal val PrimaryContent = Color.Black
}

internal object NickelLightThemeDefaultColors {
    internal val Background = Color.White
    internal val Container = Color(0xFFE3E3E3)
    internal val ContainerContent = Color.Black
    internal val Outline = Color(0xFFAFAFAF)
    internal val Primary = Color.Black
    internal val PrimaryContent = Color.White
}

internal object NickelThemeDefaultShapes {
    val Container = RoundedCornerShape(NickelThemeDefaultSizes.ContainerCornerRadius)
}

internal object NickelThemeDefaultSizes {
    val ScreenPadding = 16.dp
    val ContainerCornerRadius = 8.dp
    val ContainerSpacing = 6.dp
}
