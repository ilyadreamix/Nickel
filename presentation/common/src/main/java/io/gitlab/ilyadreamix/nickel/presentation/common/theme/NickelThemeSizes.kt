package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType

data class NickelThemeSizes(
  val screenType: ScreenType,
  val cornerRadius: CornerRadius,
  val toolbar: Toolbar,
  val navigationBar: NavigationBar,
  val iconButton: IconButton
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
    val height: Dp,
    val padding: Dp,
    val spacing: Dp,
    val itemPadding: Dp,
    val iconSize: Dp
  ) {
    val itemSize = if (width.isSpecified) {
      width - padding * 2
    } else {
      height - padding * 2
    }
  }

  data class IconButton(
    val containerSize: Dp,
    val size: Dp
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
  val iconButton = screenType.getIconButtonSizes()

  return NickelThemeSizes(
    screenType = screenType,
    cornerRadius = cornerRadius,
    toolbar = toolbar,
    navigationBar = navigationBar,
    iconButton = iconButton
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
    height = PhoneNavigationBarHeight,
    padding = PhoneNavigationBarPadding,
    spacing = PhoneNavigationBarSpacing,
    itemPadding = PhoneNavigationBarItemPadding,
    iconSize = PhoneNavigationBarIconSize
  )
  ScreenType.Tablet -> NickelThemeSizes.NavigationBar(
    width = TabletNavigationBarWidth,
    height = TabletNavigationBarHeight,
    padding = TabletNavigationBarPadding,
    spacing = TabletNavigationBarSpacing,
    itemPadding = TabletNavigationBarItemPadding,
    iconSize = TabletIconButtonSize
  )
}

private fun ScreenType.getIconButtonSizes() = when (this) {
  ScreenType.Phone -> NickelThemeSizes.IconButton(
    containerSize = PhoneIconButtonContainerSize,
    size = PhoneIconButtonSize
  )
  ScreenType.Tablet -> NickelThemeSizes.IconButton(
    containerSize = TabletIconButtonContainerSize,
    size = TabletIconButtonSize
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
private val PhoneNavigationBarHeight = 72.dp
private val PhoneNavigationBarPadding = 8.dp
private val PhoneNavigationBarSpacing = Dp.Unspecified
private val PhoneNavigationBarItemPadding = 6.dp
private val PhoneNavigationBarIconSize = 24.dp

private val PhoneIconButtonContainerSize = 48.dp
private val PhoneIconButtonSize = 24.dp

// Tablet sizes

private val TabletCornerRadiusSmall = 8.dp
private val TabletCornerRadiusMedium = 12.dp
private val TabletCornerRadiusBig = 16.dp

private val TabletToolbarHeight = 72.dp
private val TabletToolbarVerticalPadding = 8.dp
private val TabletToolbarHorizontalPadding = 16.dp

private val TabletNavigationBarWidth = 82.dp
private val TabletNavigationBarHeight = Dp.Unspecified
private val TabletNavigationBarPadding = 10.dp
private val TabletNavigationBarSpacing = 10.dp
private val TabletNavigationBarItemPadding = 6.dp
private val TabletNavigationBarIconSize = 26.dp

private val TabletIconButtonContainerSize = 56.dp
private val TabletIconButtonSize = 24.dp
