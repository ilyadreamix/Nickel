package io.gitlab.ilyadreamix.nickel.presentation.common.utility

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration

enum class ScreenType { Phone, Tablet }

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
@ReadOnlyComposable
fun getScreenType(): ScreenType {
  val configuration = LocalConfiguration.current
  val tabletScreenWidthDp = if (getOrientation() == Orientation.Landscape) {
    LandscapeTabletScreenWidthDp
  } else {
    PortraitTabletScreenWidthDp
  }

  if (configuration.screenWidthDp >= tabletScreenWidthDp) {
    return ScreenType.Tablet
  } else {
    return ScreenType.Phone
  }
}

private const val LandscapeTabletScreenWidthDp = 840
private const val PortraitTabletScreenWidthDp = 600
