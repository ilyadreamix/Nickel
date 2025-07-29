package io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType

data class NickelThemeSizesIconButton(
  val containerSize: Dp,
  val size: Dp
)

internal fun ScreenType.getIconButtonSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizesIconButton(
    containerSize = PhoneContainerSize,
    size = PhoneSize
  )
  ScreenType.Tablet -> NickelThemeSizesIconButton(
    containerSize = TabletContainerSize,
    size = TabletSize
  )
}

private val PhoneContainerSize = 48.dp
private val PhoneSize = 24.dp

private val TabletContainerSize = 56.dp
private val TabletSize = 28.dp
