package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun NickelTheme(content: @Composable () -> Unit) {

    val context = LocalContext.current

    val isDynamicColorSchemeSupported = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val isUsingDarkTheme = isSystemInDarkTheme()

    val colorScheme = when {
        isDynamicColorSchemeSupported && isUsingDarkTheme -> dynamicDarkColorScheme(context = context)
        isDynamicColorSchemeSupported && !isUsingDarkTheme -> dynamicLightColorScheme(context = context)
        isUsingDarkTheme -> NickelDefaultDarkColorScheme
        else -> NickelDefaultLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
