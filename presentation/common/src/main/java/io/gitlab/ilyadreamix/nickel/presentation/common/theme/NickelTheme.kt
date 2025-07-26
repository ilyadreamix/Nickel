package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun NickelTheme(content: @Composable () -> Unit) {
  val colorScheme = getNickelThemeColorScheme()
  val nickelSizes = getNickelThemeSizes()

  CompositionLocalProvider(LocalNickelThemeSizes provides nickelSizes) {
    MaterialTheme(
      colorScheme = colorScheme,
      motionScheme = NickelThemeMotionScheme,
      typography = NickelThemeTypography,
      content = content
    )
  }
}
