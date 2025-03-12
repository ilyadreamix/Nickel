package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.provideSystemColors

@Composable
fun NickelThemeProvider(
    colorScheme: NickelColorScheme = provideColors(),
    shapes: NickelShapes = NickelDefaultShapes,
    sizes: NickelSizes = NickelDefaultSizes,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalNickelColorScheme provides colorScheme,
        LocalNickelShapes provides shapes,
        LocalNickelSizes provides sizes,
        content = content
    )
}

@Composable
@ReadOnlyComposable
private fun provideColors(): NickelColorScheme {
    val context = LocalContext.current
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> return provideDynamicColors(context)
        isSystemInDarkTheme() -> return NickelDefaultDarkColorScheme
        else -> return NickelDefaultLightColorScheme
    }
}

@RequiresApi(Build.VERSION_CODES.S)
private fun provideDynamicColors(context: Context): NickelColorScheme {
    val systemColors = provideSystemColors(context)
    return NickelColorScheme(
        background = systemColors.background,
        container = systemColors.surfaceContainer,
        containerContent = systemColors.onSurface,
        outline = systemColors.outline,
        primary = systemColors.primary,
        primaryContent = systemColors.onPrimary
    )
}
