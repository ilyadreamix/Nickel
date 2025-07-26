package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun NickelTheme(content: @Composable () -> Unit) {
  val colorScheme = if (isSystemInDarkTheme()) {
    NickelDarkColorScheme
  } else {
    NickelLightColorScheme
  }
  val nickelSizes = getNickelThemeSizes()

  CompositionLocalProvider(LocalNickelThemeSizes provides nickelSizes) {
    MaterialTheme(
      colorScheme = colorScheme,
      content = content
    )
  }
}
