package io.gitlab.ilyadreamix.nickel.presentation.common.utility

import android.content.Context
import android.content.res.Configuration
import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat

fun Context.provideColor(@ColorRes id: Int): Color {
    val hex = ContextCompat.getColor(this, id)
    return Color(hex)
}

fun Context.isDarkThemeEnabled() =
    resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
