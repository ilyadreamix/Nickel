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

  data class Toolbar(
    val height: Dp,
    val verticalPadding: Dp,
    val horizontalPadding: Dp
  )

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
@ReadOnlyComposable
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
  ScreenType.Phone -> NickelThemeSizes.Toolbar(
    height = PhoneToolbarHeight,
    verticalPadding = PhoneToolbarVerticalPadding,
    horizontalPadding = PhoneToolbarHorizontalPadding
  )
  ScreenType.Tablet -> NickelThemeSizes.Toolbar(
    height = TabletToolbarHeight,
    verticalPadding = TabletToolbarVerticalPadding,
    horizontalPadding = TabletToolbarHorizontalPadding
  )
}

private fun ScreenType.getNavigationBarSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizes.NavigationBar(
    width = PhoneNavigationBarWidth,
    height = PhoneNavigationBarHeight
  )
  ScreenType.Tablet -> NickelThemeSizes.NavigationBar(
    width = TabletNavigationBarWidth,
    height = TabletNavigationBarHeight
  )
}

// Phone sizes

private val PhoneCornerRadiusSmall = 6.dp
private val PhoneCornerRadiusMedium = 8.dp
private val PhoneCornerRadiusBig = 12.dp

private val PhoneToolbarHeight = 56.dp
private val PhoneToolbarVerticalPadding = 4.dp
private val PhoneToolbarHorizontalPadding = 8.dp

private val PhoneNavigationBarWidth = Dp.Unspecified
private val PhoneNavigationBarHeight = 56.dp

// Tablet sizes

private val TabletCornerRadiusSmall = 8.dp
private val TabletCornerRadiusMedium = 12.dp
private val TabletCornerRadiusBig = 16.dp

private val TabletToolbarHeight = 72.dp
private val TabletToolbarVerticalPadding = 8.dp
private val TabletToolbarHorizontalPadding = 16.dp

private val TabletNavigationBarWidth = 72.dp
private val TabletNavigationBarHeight = Dp.Unspecified
