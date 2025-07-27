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
internal val NickelThemeTypography = with(DefaultTypography) {
  copy(
    displayLarge = displayLarge.copy(fontFamily = FontFamilyHankenGrotesk),
    displayMedium = displayMedium.copy(fontFamily = FontFamilyHankenGrotesk),
    displaySmall = displaySmall.copy(fontFamily = FontFamilyHankenGrotesk),
    headlineLarge = headlineLarge.copy(fontFamily = FontFamilyHankenGrotesk),
    headlineMedium = headlineMedium.copy(fontFamily = FontFamilyHankenGrotesk),
    headlineSmall = headlineSmall.copy(fontFamily = FontFamilyHankenGrotesk),
    titleLarge = titleLarge.copy(fontFamily = FontFamilyHankenGrotesk),
    titleMedium = titleMedium.copy(fontFamily = FontFamilyHankenGrotesk),
    titleSmall = titleSmall.copy(fontFamily = FontFamilyHankenGrotesk),
    bodyLarge = bodyLarge.copy(fontFamily = FontFamilyHankenGrotesk),
    bodyMedium = bodyMedium.copy(fontFamily = FontFamilyHankenGrotesk),
    bodySmall = bodySmall.copy(fontFamily = FontFamilyHankenGrotesk),
    labelLarge = labelLarge.copy(fontFamily = FontFamilyHankenGrotesk),
    labelMedium = labelMedium.copy(fontFamily = FontFamilyHankenGrotesk),
    labelSmall = labelSmall.copy(fontFamily = FontFamilyHankenGrotesk),
  )
}
