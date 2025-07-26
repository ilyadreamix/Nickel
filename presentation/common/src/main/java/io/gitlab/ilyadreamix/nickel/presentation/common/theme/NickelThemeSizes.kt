package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType

data class NickelThemeSizes(
  val screenType: ScreenType,
  val cornerRadius: CornerRadius,
  val toolbar: Toolbar,
  val navigationBar: NavigationBar
) {
  data class CornerRadius(
    val small: Dp,
    val medium: Dp,
    val big: Dp
  )

  data class Toolbar(val height: Dp)

  data class NavigationBar(
    val width: Dp,
    val height: Dp
  )
}

internal val LocalNickelThemeSizes = staticCompositionLocalOf<NickelThemeSizes> { throw IllegalStateException() }

@Suppress("UnusedReceiverParameter")
val MaterialTheme.nickelSizes
  @Composable
  @ReadOnlyComposable
  get() = LocalNickelThemeSizes.current

@Composable
internal fun getNickelThemeSizes(): NickelThemeSizes {

  val screenType = getScreenType()

  val cornerRadius = screenType.getCornerRadiusSizes()
  val toolbar = screenType.getToolbarSizes()
  val navigationBar = screenType.getNavigationBarSizes()

  return NickelThemeSizes(
    screenType = screenType,
    cornerRadius = cornerRadius,
    toolbar = toolbar,
    navigationBar = navigationBar
  )
}

private fun ScreenType.getCornerRadiusSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizes.CornerRadius(
    small = PhoneCornerRadiusSmall,
    medium = PhoneCornerRadiusMedium,
    big = PhoneCornerRadiusBig
  )
  ScreenType.Tablet -> NickelThemeSizes.CornerRadius(
    small = TabletCornerRadiusSmall,
    medium = TabletCornerRadiusMedium,
    big = TabletCornerRadiusBig
  )
}

private fun ScreenType.getToolbarSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizes.Toolbar(height = 56.dp)
  ScreenType.Tablet -> NickelThemeSizes.Toolbar(height = 72.dp)
}

private fun ScreenType.getNavigationBarSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizes.NavigationBar(
    width = Dp.Unspecified,
    height = 56.dp
  )
  ScreenType.Tablet -> NickelThemeSizes.NavigationBar(
    width = 72.dp,
    height = Dp.Unspecified
  )
}

private val PhoneCornerRadiusSmall = 6.dp
private val PhoneCornerRadiusMedium = 8.dp
private val PhoneCornerRadiusBig = 12.dp

private val TabletCornerRadiusSmall = 8.dp
private val TabletCornerRadiusMedium = 12.dp
private val TabletCornerRadiusBig = 16.dp
