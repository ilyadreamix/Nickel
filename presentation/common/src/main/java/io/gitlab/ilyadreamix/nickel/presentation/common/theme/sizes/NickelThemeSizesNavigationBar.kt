package io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.square
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.withHeight

data class NickelThemeSizesNavigationBar(
  val size: DpSize,
  val padding: PaddingValues,
  val spacing: Dp,
  val itemPadding: PaddingValues,
  val itemIconSize: DpSize,
  val itemSize: DpSize
)

internal fun ScreenType.getNavigationBarSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizesNavigationBar(
    size = PhoneSize,
    padding = PhonePadding,
    spacing = PhoneSpacing,
    itemPadding = PhoneItemPadding,
    itemIconSize = PhoneItemIconSize,
    itemSize = PhoneItemSize
  )
  ScreenType.Tablet -> NickelThemeSizesNavigationBar(
    size = TabletSize,
    padding = TabletPadding,
    spacing = TabletSpacing,
    itemPadding = TabletItemPadding,
    itemIconSize = TabletItemIconSize,
    itemSize = TabletItemSize
  )
}

private val PhoneSize = Dp.Unspecified withHeight 64.dp
private val PhonePadding = PaddingValues(8.dp)
private val PhoneSpacing = Dp.Unspecified
private val PhoneItemPadding = PaddingValues(4.dp)
private val PhoneItemIconSize = 24.dp.square
private val PhoneItemSize = 56.dp withHeight 78.dp

private val TabletSize = 100.dp withHeight Dp.Unspecified
private val TabletPadding = PaddingValues(10.dp)
private val TabletSpacing = 10.dp
private val TabletItemPadding = PaddingValues(6.dp)
private val TabletItemIconSize = 26.dp.square
private val TabletItemSize = 80.dp withHeight 58.dp
