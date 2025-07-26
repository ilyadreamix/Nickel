package io.gitlab.ilyadreamix.nickel.presentation.common.helper

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration

internal enum class ScreenType { Phone, Tablet }

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
@ReadOnlyComposable
internal fun getScreenType(): ScreenType {
  val configuration = LocalConfiguration.current
  val screenWidthDp = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    LandscapeScreenWidthDp
  } else {
    PortraitScreenWidthDp
  }

  if (configuration.screenWidthDp < screenWidthDp) {
    return ScreenType.Phone
  } else {
    return ScreenType.Tablet
  }
}

private const val LandscapeScreenWidthDp = 840
private const val PortraitScreenWidthDp = 600
