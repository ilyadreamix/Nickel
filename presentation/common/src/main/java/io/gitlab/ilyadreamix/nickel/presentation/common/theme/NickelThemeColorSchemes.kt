package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val LightBackground = Color.White
private val LightPrimary = Color.Black
private val LightOnPrimary = Color.White
private val LightOutline = Color(0xFFAFAFAF)

private val DarkBackground = Color.Black
private val DarkPrimary = Color.White
private val DarkOnPrimary = Color.Black
private val DarkOutline = Color(0xFF505050)

internal val NickelLightColorScheme = lightColorScheme(
  background = LightBackground,
  primary = LightPrimary,
  onPrimary = LightOnPrimary,
  outline = LightOutline
)

internal val NickelDarkColorScheme = darkColorScheme(
  background = DarkBackground,
  primary = DarkPrimary,
  onPrimary = DarkOnPrimary,
  outline = DarkOutline
)
