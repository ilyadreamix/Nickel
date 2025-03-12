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
    colors: NickelColors = provideColors(),
    shapes: NickelShapes = NickelShapes(),
    sizes: NickelSizes = NickelSizes(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalNickelColors provides colors,
        LocalNickelShapes provides shapes,
        LocalNickelSizes provides sizes,
        content = content
    )
}

@Composable
@ReadOnlyComposable
private fun provideColors(): NickelColors {
    val context = LocalContext.current
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> return provideDynamicColors(context)
        isSystemInDarkTheme() -> return NickelDarkColors
        else -> return NickelLightColors
    }
}

@RequiresApi(Build.VERSION_CODES.S)
private fun provideDynamicColors(context: Context): NickelColors {
    val systemColors = provideSystemColors(context)
    return NickelColors(
        background = systemColors.background,
        container = systemColors.surfaceContainer,
        containerContent = systemColors.onSurface,
        outline = systemColors.outline,
        primary = systemColors.primary,
        primaryContent = systemColors.onPrimary
    )
}
