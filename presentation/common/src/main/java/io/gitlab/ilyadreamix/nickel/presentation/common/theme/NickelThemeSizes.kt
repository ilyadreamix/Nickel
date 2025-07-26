package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.helper.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.helper.getScreenType

data class NickelThemeSizes(val cornerRadius: CornerRadius) {
  data class CornerRadius(
    val small: Dp,
    val medium: Dp,
    val big: Dp
  )
}

val LocalNickelThemeSizes = staticCompositionLocalOf<NickelThemeSizes> { throw IllegalStateException() }

val MaterialTheme.nickelSizes
  @[Composable ReadOnlyComposable] get() = LocalNickelThemeSizes.current

@Composable
@ReadOnlyComposable
internal fun getNickelThemeSizes(): NickelThemeSizes {
  val screenType = getScreenType()
  val cornerRadius = getCornerRadiusSizes(screenType)
  return NickelThemeSizes(cornerRadius = cornerRadius)
}

private fun getCornerRadiusSizes(screenType: ScreenType) = when (screenType) {
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

private val PhoneCornerRadiusSmall = 6.dp
private val PhoneCornerRadiusMedium = 8.dp
private val PhoneCornerRadiusBig = 12.dp

private val TabletCornerRadiusSmall = 8.dp
private val TabletCornerRadiusMedium = 12.dp
private val TabletCornerRadiusBig = 16.dp
