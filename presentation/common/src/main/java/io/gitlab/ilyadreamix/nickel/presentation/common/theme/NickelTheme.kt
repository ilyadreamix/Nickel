package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

data class NickelColors(
    val background: Color = NickelLightThemeDefaultColors.Background,
    val container: Color = NickelLightThemeDefaultColors.Container,
    val containerContent: Color = NickelLightThemeDefaultColors.ContainerContent,
    val outline: Color = NickelLightThemeDefaultColors.Outline,
    val primary: Color = NickelLightThemeDefaultColors.Primary,
    val primaryContent: Color = NickelLightThemeDefaultColors.PrimaryContent
)

internal val NickelLightColors = NickelColors(
    background = NickelLightThemeDefaultColors.Background,
    container = NickelLightThemeDefaultColors.Container,
    containerContent = NickelLightThemeDefaultColors.ContainerContent,
    outline = NickelLightThemeDefaultColors.Outline,
    primary = NickelLightThemeDefaultColors.Primary,
    primaryContent = NickelLightThemeDefaultColors.PrimaryContent
)

internal val NickelDarkColors = NickelColors(
    background = NickelDarkThemeDefaultColors.Background,
    container = NickelDarkThemeDefaultColors.Container,
    containerContent = NickelDarkThemeDefaultColors.ContainerContent,
    outline = NickelDarkThemeDefaultColors.Outline,
    primary = NickelDarkThemeDefaultColors.Primary,
    primaryContent = NickelDarkThemeDefaultColors.PrimaryContent
)

data class NickelShapes(val container: Shape = NickelThemeDefaultShapes.Container)

data class NickelSizes(
    val screenPadding: Dp = NickelThemeDefaultSizes.ScreenPadding,
    val containerCornerRadius: Dp = NickelThemeDefaultSizes.ContainerCornerRadius,
    val containerSpacing: Dp = NickelThemeDefaultSizes.ContainerSpacing
)

val LocalNickelShapes = staticCompositionLocalOf { NickelShapes() }
val LocalNickelColors = staticCompositionLocalOf { NickelColors() }
val LocalNickelSizes = staticCompositionLocalOf { NickelSizes() }

object NickelTheme {
    val colors
        @Composable
        @ReadOnlyComposable
        get() = LocalNickelColors.current

    val shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalNickelShapes.current

    val sizes
        @Composable
        @ReadOnlyComposable
        get() = LocalNickelSizes.current
}
