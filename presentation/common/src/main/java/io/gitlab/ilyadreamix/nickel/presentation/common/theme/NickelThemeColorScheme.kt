package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightBackground = Color.White
private val LightOnBackground = Color.Black
private val LightPrimary = Color(0xFF282828)
private val LightOnPrimary = Color.White
private val LightOutline = Color(0xFFD5D5D5)
private val LightSurface = Color.White
private val LightOnSurface = Color.Black

private val DarkBackground = Color.Black
private val DarkOnBackground = Color.White
private val DarkPrimary = Color(0xFFD7D7D7)
private val DarkOnPrimary = Color.Black
private val DarkOutline = Color(0xFF262626)
private val DarkSurface = Color.Black
private val DarkOnSurface = Color.White

internal val NickelLightColorScheme = lightColorScheme(
  background = LightBackground,
  onBackground = LightOnBackground,
  primary = LightPrimary,
  onPrimary = LightOnPrimary,
  outline = LightOutline,
  outlineVariant = LightOutline,
  surface = LightSurface,
  onSurface = LightOnSurface
)

internal val NickelDarkColorScheme = darkColorScheme(
  background = DarkBackground,
  onBackground = DarkOnBackground,
  primary = DarkPrimary,
  onPrimary = DarkOnPrimary,
  outline = DarkOutline,
  outlineVariant = DarkOutline,
  surface = DarkSurface,
  onSurface = DarkOnSurface
)

@Composable
@ReadOnlyComposable
internal fun getNickelThemeColorScheme(): ColorScheme {
  val colorScheme = if (isSystemInDarkTheme()) {
    NickelDarkColorScheme
  } else {
    NickelLightColorScheme
  }
  val surfaceContainer = colorScheme.surfaceColorAtElevation(SurfaceContainerElevation)
  return colorScheme.copy(surfaceContainer = surfaceContainer)
}

private val SurfaceContainerElevation = 3.dp
