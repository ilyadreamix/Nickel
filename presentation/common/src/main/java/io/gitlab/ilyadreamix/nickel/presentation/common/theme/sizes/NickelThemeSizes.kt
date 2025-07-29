package io.gitlab.ilyadreamix.nickel.presentation.common.theme.sizes

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType

data class NickelThemeSizes(
  val screenType: ScreenType,
  val cornerRadius: NickelThemeSizesCornerRadius,
  val toolbar: NickelThemeSizesToolbar,
  val navigationBar: NickelThemeSizesNavigationBar,
  val iconButton: NickelThemeSizesIconButton
)

val LocalNickelThemeSizes = staticCompositionLocalOf<NickelThemeSizes> { throw IllegalStateException() }

@Suppress("UnusedReceiverParameter")
val MaterialTheme.nickelSizes
  @Composable
  @ReadOnlyComposable
  get() = LocalNickelThemeSizes.current

@Composable
@ReadOnlyComposable
internal fun getDefaultNickelThemeSizes(): NickelThemeSizes {

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
