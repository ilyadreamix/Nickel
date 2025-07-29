package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.DpSize

@Composable
fun NickelFixedSizeLayout(
  size: DpSize,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  Layout(
    content = content,
    modifier = modifier,
  ) { measurables, _ ->

    val widthPx = size.width.roundToPx()
    val heightPx = size.height.roundToPx()

    val constraints = Constraints.fixed(width = widthPx, height = heightPx)
    val placeable = measurables.first().measure(constraints)

    return@Layout layout(width = widthPx, height = heightPx) {
      placeable.place(x = 0, y = 0)
    }
  }
}
