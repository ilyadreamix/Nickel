package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

data class NickelColorScheme(
    val background: Color,
    val container: Color,
    val containerContent: Color,
    val outline: Color,
    val primary: Color,
    val primaryContent: Color
)

data class NickelSizes(
    val screenPadding: Dp,
    val containerCornerRadius: Dp,
    val containerSpacing: Dp
)

data class NickelShapes(val container: Shape)

val LocalNickelColorScheme = staticCompositionLocalOf<NickelColorScheme> { throw IllegalStateException() }
val LocalNickelSizes = staticCompositionLocalOf<NickelSizes> { throw IllegalStateException() }
val LocalNickelShapes = staticCompositionLocalOf<NickelShapes> { throw IllegalStateException() }

object NickelTheme {
    val colorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalNickelColorScheme.current

    val sizes
        @Composable
        @ReadOnlyComposable
        get() = LocalNickelSizes.current

    val shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalNickelShapes.current
}
