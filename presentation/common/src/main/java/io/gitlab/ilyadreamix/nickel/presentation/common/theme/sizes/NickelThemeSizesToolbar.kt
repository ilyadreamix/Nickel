package io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType

data class NickelThemeSizesToolbar(
  val height: Dp,
  val padding: PaddingValues
)

internal fun ScreenType.getToolbarSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizesToolbar(
    height = PhoneHeight,
    padding = PhonePadding
  )
  ScreenType.Tablet -> NickelThemeSizesToolbar(
    height = TabletHeight,
    padding = TabletPadding
  )
}

private val PhoneHeight = 56.dp
private val PhonePadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp)

private val TabletHeight = 72.dp
private val TabletPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
