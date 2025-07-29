package io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType

data class NickelThemeSizesNavigationBar(
  val width: Dp,
  val height: Dp,
  val padding: Dp,
  val spacing: Dp,
  val itemPadding: PaddingValues,
  val iconSize: Dp,
  val itemHeight: Dp,
  val itemWidth: Dp
)

internal fun ScreenType.getNavigationBarSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizesNavigationBar(
    width = PhoneWidth,
    height = PhoneHeight,
    padding = PhonePadding,
    spacing = PhoneSpacing,
    itemPadding = PhoneItemPadding,
    iconSize = PhoneIconSize,
    itemHeight = PhoneItemHeight,
    itemWidth = PhoneItemWidth
  )
  ScreenType.Tablet -> NickelThemeSizesNavigationBar(
    width = TabletWidth,
    height = TabletHeight,
    padding = TabletPadding,
    spacing = TabletSpacing,
    itemPadding = TabletItemPadding,
    iconSize = TabletIconSize,
    itemHeight = TabletItemHeight,
    itemWidth = TabletItemWidth
  )
}

private val PhoneWidth = Dp.Unspecified
private val PhoneHeight = 64.dp
private val PhonePadding = 8.dp
private val PhoneSpacing = Dp.Unspecified
private val PhoneItemPadding = PaddingValues(4.dp)
private val PhoneIconSize = 24.dp
private val PhoneItemHeight = 56.dp
private val PhoneItemWidth = 78.dp

private val TabletWidth = 100.dp
private val TabletHeight = Dp.Unspecified
private val TabletPadding = 10.dp
private val TabletSpacing = 10.dp
private val TabletItemPadding = PaddingValues(6.dp)
private val TabletIconSize = 26.dp
private val TabletItemHeight = 58.dp
private val TabletItemWidth = 80.dp
