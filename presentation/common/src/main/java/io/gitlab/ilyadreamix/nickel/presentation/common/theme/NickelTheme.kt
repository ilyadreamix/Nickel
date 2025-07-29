package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes.LocalNickelThemeSizes
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes.getDefaultNickelThemeSizes

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun NickelTheme(content: @Composable () -> Unit) {
  val colorScheme = getDefaultNickelThemeColorScheme()
  val nickelSizes = getDefaultNickelThemeSizes()
  val indication = rememberNickelIndication()

  MaterialTheme(
    colorScheme = colorScheme,
    motionScheme = NickelThemeMotionScheme,
    typography = NickelThemeTypography,
  ) {
    CompositionLocalProvider(
      LocalNickelThemeSizes provides nickelSizes,
      LocalIndication provides indication,
      content = content
    )
  }
}
