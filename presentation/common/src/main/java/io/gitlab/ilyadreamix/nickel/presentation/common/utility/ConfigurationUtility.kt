package io.gitlab.ilyadreamix.nickel.presentation.common.utility

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration

enum class Orientation { Landscape, Portrait }

@ReadOnlyComposable
@Composable
fun getOrientation(): Orientation {
  val configuration = LocalConfiguration.current
  return when (configuration.orientation) {
    Configuration.ORIENTATION_LANDSCAPE -> Orientation.Landscape
    Configuration.ORIENTATION_PORTRAIT -> Orientation.Portrait
    else -> throw IllegalStateException()
  }
}
