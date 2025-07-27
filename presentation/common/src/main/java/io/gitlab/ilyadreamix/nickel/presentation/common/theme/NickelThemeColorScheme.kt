package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

private val LightBackground = Color.White
private val LightOnBackground = Color.Black
private val LightPrimary = Color.Black
private val LightOnPrimary = Color.White
private val LightOutline = Color(0xFFAFAFAF)
private val LightSurface = Color.White
private val LightOnSurface = Color.Black

private val DarkBackground = Color.Black
private val DarkOnBackground = Color.White
private val DarkPrimary = Color.White
private val DarkOnPrimary = Color.Black
private val DarkOutline = Color(0xFF505050)
private val DarkSurface = Color.Black
private val DarkOnSurface = Color.White

internal val NickelLightColorScheme = lightColorScheme(
  background = LightBackground,
  onBackground = LightOnBackground,
  primary = LightPrimary,
  onPrimary = LightOnPrimary,
  outline = LightOutline,
  surface = LightSurface,
  onSurface = LightOnSurface
)

internal val NickelDarkColorScheme = darkColorScheme(
  background = DarkBackground,
  onBackground = DarkOnBackground,
  primary = DarkPrimary,
  onPrimary = DarkOnPrimary,
  outline = DarkOutline,
  surface = DarkSurface,
  onSurface = DarkOnSurface
)

@Composable
@ReadOnlyComposable
internal fun getNickelThemeColorScheme() =
  if (isSystemInDarkTheme()) {
    NickelDarkColorScheme
  } else {
    NickelLightColorScheme
  }
