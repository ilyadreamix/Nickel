package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import io.gitlab.ilyadreamix.nickel.presentation.common.R

private val FontFamilyInter = FontFamily(
  Font(resId = R.font.presentation_common_inter_regular),
  Font(resId = R.font.presentation_common_inter_italic, style = FontStyle.Italic),
  Font(resId = R.font.presentation_common_inter_bold, weight = FontWeight.Bold),
  Font(resId = R.font.presentation_common_inter_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
)

private val DefaultTypography = Typography()
internal val NickelThemeTypography = with(DefaultTypography) {
  copy(
    displayLarge = displayLarge.copy(fontFamily = FontFamilyInter),
    displayMedium = displayMedium.copy(fontFamily = FontFamilyInter),
    displaySmall = displaySmall.copy(fontFamily = FontFamilyInter),
    headlineLarge = headlineLarge.copy(fontFamily = FontFamilyInter),
    headlineMedium = headlineMedium.copy(fontFamily = FontFamilyInter),
    headlineSmall = headlineSmall.copy(fontFamily = FontFamilyInter),
    titleLarge = titleLarge.copy(fontFamily = FontFamilyInter),
    titleMedium = titleMedium.copy(fontFamily = FontFamilyInter),
    titleSmall = titleSmall.copy(fontFamily = FontFamilyInter),
    bodyLarge = bodyLarge.copy(fontFamily = FontFamilyInter),
    bodyMedium = bodyMedium.copy(fontFamily = FontFamilyInter),
    bodySmall = bodySmall.copy(fontFamily = FontFamilyInter),
    labelLarge = labelLarge.copy(fontFamily = FontFamilyInter),
    labelMedium = labelMedium.copy(fontFamily = FontFamilyInter),
    labelSmall = labelSmall.copy(fontFamily = FontFamilyInter),
  )
}
