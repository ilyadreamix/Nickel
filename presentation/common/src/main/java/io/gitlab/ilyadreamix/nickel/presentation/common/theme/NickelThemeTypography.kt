package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import io.gitlab.ilyadreamix.nickel.presentation.common.R

private val FontFamilyHankenGrotesk = FontFamily(
  Font(resId = R.font.presentation_common_hanken_grotesk_regular),
  Font(resId = R.font.presentation_common_hanken_grotesk_regular_italic, style = FontStyle.Italic),
  Font(resId = R.font.presentation_common_hanken_grotesk_bold, weight = FontWeight.Bold),
  Font(resId = R.font.presentation_common_hanken_grotesk_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
)

private val DefaultTypography = Typography()

internal val NickelThemeTypography = Typography(
  displayLarge = DefaultTypography.displayLarge.copy(fontFamily = FontFamilyHankenGrotesk),
  displayMedium = DefaultTypography.displayMedium.copy(fontFamily = FontFamilyHankenGrotesk),
  displaySmall = DefaultTypography.displaySmall.copy(fontFamily = FontFamilyHankenGrotesk),
  headlineLarge = DefaultTypography.headlineLarge.copy(fontFamily = FontFamilyHankenGrotesk),
  headlineMedium = DefaultTypography.headlineMedium.copy(fontFamily = FontFamilyHankenGrotesk),
  headlineSmall = DefaultTypography.headlineSmall.copy(fontFamily = FontFamilyHankenGrotesk),
  titleLarge = DefaultTypography.titleLarge.copy(fontFamily = FontFamilyHankenGrotesk),
  titleMedium = DefaultTypography.titleMedium.copy(fontFamily = FontFamilyHankenGrotesk),
  titleSmall = DefaultTypography.titleSmall.copy(fontFamily = FontFamilyHankenGrotesk),
  bodyLarge = DefaultTypography.bodyLarge.copy(fontFamily = FontFamilyHankenGrotesk),
  bodyMedium = DefaultTypography.bodyMedium.copy(fontFamily = FontFamilyHankenGrotesk),
  bodySmall = DefaultTypography.bodySmall.copy(fontFamily = FontFamilyHankenGrotesk),
  labelLarge = DefaultTypography.labelLarge.copy(fontFamily = FontFamilyHankenGrotesk),
  labelMedium = DefaultTypography.labelMedium.copy(fontFamily = FontFamilyHankenGrotesk),
  labelSmall = DefaultTypography.labelSmall.copy(fontFamily = FontFamilyHankenGrotesk),
)
