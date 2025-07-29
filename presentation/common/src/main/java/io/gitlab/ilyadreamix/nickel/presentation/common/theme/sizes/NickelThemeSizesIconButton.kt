package io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.square

data class NickelThemeSizesIconButton(
  val containerSize: DpSize,
  val size: DpSize
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

private val PhoneContainerSize = 48.dp.square
private val PhoneSize = 24.dp.square

private val TabletContainerSize = 56.dp.square
private val TabletSize = 28.dp.square
