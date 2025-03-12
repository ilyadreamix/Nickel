package io.gitlab.ilyadreamix.nickel.presentation.common.utility

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color

@RequiresApi(Build.VERSION_CODES.S)
internal data class SystemColors(
    val background: Color,
    val primary: Color,
    val onPrimary: Color,
    val outline: Color,
    val surfaceContainer: Color,
    val onSurface: Color
)

@RequiresApi(Build.VERSION_CODES.S)
internal fun provideSystemColors(context: Context): SystemColors {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
        return provideSystemColorsSdk34(context)
    } else {
        return provideSystemColorsSdk31(context)
    }
}

@RequiresApi(Build.VERSION_CODES.S)
private fun provideSystemColorsSdk31(context: Context): SystemColors {
    val background = context.provideColor(android.R.color.system_accent1_10)
    val primary = context.provideColor(android.R.color.system_accent1_200)
    val onPrimary = context.provideColor(android.R.color.system_accent1_0)
    val outline = context.provideColor(android.R.color.system_neutral2_400)
    val surfaceContainer = context.provideColor(android.R.color.system_neutral2_50)
    val onSurface = context.provideColor(android.R.color.system_neutral2_900)

    return SystemColors(
        background = background,
        primary = primary,
        onPrimary = onPrimary,
        outline = outline,
        surfaceContainer = surfaceContainer,
        onSurface = onSurface
    )
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
private fun provideSystemColorsSdk34(context: Context): SystemColors {
    if (context.isDarkThemeEnabled()) {
        return provideSystemSystemDarkColorsSdk34(context)
    } else {
        return provideSystemLightColorsSdk34(context)
    }
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
private fun provideSystemLightColorsSdk34(context: Context): SystemColors {
    val background = context.provideColor(android.R.color.system_background_light)
    val primary = context.provideColor(android.R.color.system_primary_light)
    val onPrimary = context.provideColor(android.R.color.system_on_primary_light)
    val outline = context.provideColor(android.R.color.system_outline_light)
    val surfaceContainer = context.provideColor(android.R.color.system_surface_container_light)
    val onSurface = context.provideColor(android.R.color.system_on_surface_light)

    return SystemColors(
        background = background,
        primary = primary,
        onPrimary = onPrimary,
        outline = outline,
        surfaceContainer = surfaceContainer,
        onSurface = onSurface
    )
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
private fun provideSystemSystemDarkColorsSdk34(context: Context): SystemColors {
    val background = context.provideColor(android.R.color.system_background_dark)
    val primary = context.provideColor(android.R.color.system_primary_dark)
    val onPrimary = context.provideColor(android.R.color.system_on_primary_dark)
    val outline = context.provideColor(android.R.color.system_outline_dark)
    val surfaceContainer = context.provideColor(android.R.color.system_surface_container_dark)
    val onSurface = context.provideColor(android.R.color.system_on_surface_dark)

    return SystemColors(
        background = background,
        primary = primary,
        onPrimary = onPrimary,
        outline = outline,
        surfaceContainer = surfaceContainer,
        onSurface = onSurface
    )
}
