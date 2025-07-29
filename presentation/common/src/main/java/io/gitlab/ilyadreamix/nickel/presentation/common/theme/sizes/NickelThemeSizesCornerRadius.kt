package io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType

data class NickelThemeSizesCornerRadius(
  val small: Dp,
  val medium: Dp,
  val big: Dp
)

internal fun ScreenType.getCornerRadiusSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizesCornerRadius(
    small = PhoneSmall,
    medium = PhoneMedium,
    big = PhoneBig
  )
  ScreenType.Tablet -> NickelThemeSizesCornerRadius(
    small = TabletSmall,
    medium = TabletMedium,
    big = TabletBig
  )
}

private val PhoneSmall = 6.dp
private val PhoneMedium = 8.dp
private val PhoneBig = 12.dp

private val TabletSmall = 8.dp
private val TabletMedium = 12.dp
private val TabletBig = 16.dp
