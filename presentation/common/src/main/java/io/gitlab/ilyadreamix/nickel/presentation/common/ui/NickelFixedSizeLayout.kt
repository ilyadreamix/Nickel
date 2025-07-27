package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp

@Composable
internal fun NickelFixedSizeLayout(
  width: Dp,
  height: Dp,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  Layout(
    content = content,
    modifier = modifier,
  ) { measurables, _ ->

    val widthPx = width.roundToPx()
    val heightPx = height.roundToPx()

    val constraints = Constraints.fixed(width = widthPx, height = heightPx)
    val placeable = measurables.first().measure(constraints)

    return@Layout layout(width = widthPx, height = heightPx) {
      placeable.place(x = 0, y = 0)
    }
  }
}

@Composable
internal fun NickelFixedSizeLayout(
  size: Dp,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  NickelFixedSizeLayout(
    width = size,
    height = size,
    modifier = modifier,
    content = content
  )
}
