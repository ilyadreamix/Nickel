package io.gitlab.ilyadreamix.nickel.presentation.common.utility

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union

val WindowInsets.Companion.ui
  @Composable
  get() = systemBars.union(displayCutout)

@Composable
@ReadOnlyComposable
fun Modifier.windowInsetsPartialPadding(
  windowInsets: WindowInsets,
  top: Boolean = false,
  start: Boolean = false,
  bottom: Boolean = false,
  end: Boolean = false
): Modifier {

  val layoutDirection = LocalLayoutDirection.current
  val density = LocalDensity.current

  val paddingValues = windowInsets.asPaddingValues()

  val topDp = with(density) { paddingValues.calculateTopPadding() }
  val startDp = with(density) { paddingValues.calculateStartPadding(layoutDirection) }
  val bottomDp = with(density) { paddingValues.calculateBottomPadding() }
  val endDp = with(density) { paddingValues.calculateEndPadding(layoutDirection) }

  return padding(
    top = if (top) topDp else 0.dp,
    start = if (start) startDp else 0.dp,
    bottom = if (bottom) bottomDp else 0.dp,
    end = if (end) endDp else 0.dp
  )
}
