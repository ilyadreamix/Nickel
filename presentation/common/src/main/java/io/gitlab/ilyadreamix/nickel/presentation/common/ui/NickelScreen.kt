package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.NickelPreviewPhone
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.NickelPreviewTablet
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ui

@Composable
fun NickelScreen(
  modifier: Modifier = Modifier,
  color: Color = MaterialTheme.colorScheme.background,
  contentColor: Color = MaterialTheme.colorScheme.onBackground,
  toolbar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  navigationBar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  content: @Composable (innerPadding: PaddingValues) -> Unit,
) {

  val screenType = getScreenType()

  NickelSurface(
    modifier = modifier,
    color = color,
    contentColor = contentColor
  ) {
    when (screenType) {
      ScreenType.Phone -> PhoneScreenLayout(
        toolbar = toolbar,
        navigationBar = navigationBar,
        content = content
      )
      ScreenType.Tablet -> TabletScreenLayout(
        toolbar = toolbar,
        navigationBar = navigationBar,
        content = content
      )
    }
  }
}

@Composable
private fun PhoneScreenLayout(
  toolbar: (@Composable (innerPadding: PaddingValues) -> Unit)?,
  navigationBar: (@Composable (innerPadding: PaddingValues) -> Unit)?,
  content: @Composable (innerPadding: PaddingValues) -> Unit,
  modifier: Modifier = Modifier,
) {

  val insetsPadding = WindowInsets.ui.asPaddingValues()

  SubcomposeLayout(modifier = modifier) { constraints ->
    val toolbarMeasurables = if (toolbar != null) {
      subcompose(slotId = SlotToolbar) { toolbar(PaddingValues.Zero) }
    } else {
      emptyList()
    }
    val toolbarPlaceable = toolbarMeasurables.firstOrNull()?.measure(constraints)

    val navigationBarMeasurables = if (navigationBar != null) {
      subcompose(slotId = SlotNavigationBar) { navigationBar(PaddingValues.Zero) }
    } else {
      emptyList()
    }
    val navigationBarPlaceable = navigationBarMeasurables.firstOrNull()?.measure(constraints)

    val contentPadding = PaddingValues(
      top = toolbarPlaceable?.height?.toDp() ?: 0.dp,
      bottom = navigationBarPlaceable?.height?.toDp() ?: 0.dp,
      start = insetsPadding.calculateStartPadding(layoutDirection),
      end = insetsPadding.calculateEndPadding(layoutDirection)
    )
    val contentMeasurable = subcompose(slotId = SlotContent) { content(contentPadding) }
    val contentPlaceable = contentMeasurable.first().measure(constraints)

    return@SubcomposeLayout layout(width = constraints.maxWidth, height = constraints.maxHeight) {

      contentPlaceable.placeRelative(x = 0, y = 0)

      if (navigationBarPlaceable != null) {
        val positionY = constraints.maxHeight - navigationBarPlaceable.height
        navigationBarPlaceable.placeRelative(x = 0, y = positionY)
      }

      toolbarPlaceable?.placeRelative(x = 0, y = 0)
    }
  }
}

@Composable
private fun TabletScreenLayout(
  toolbar: (@Composable (innerPadding: PaddingValues) -> Unit)?,
  navigationBar: (@Composable (innerPadding: PaddingValues) -> Unit)?,
  content: @Composable (innerPadding: PaddingValues) -> Unit,
  modifier: Modifier = Modifier,
) {
  SubcomposeLayout(modifier = modifier) { constraints ->
    val navigationBarMeasurables = if (navigationBar != null) {
      subcompose(slotId = SlotNavigationBar) { navigationBar(PaddingValues.Zero) }
    } else {
      emptyList()
    }
    val navigationBarPlaceable = navigationBarMeasurables.firstOrNull()?.measure(constraints)

    val toolbarPadding = PaddingValues(start = navigationBarPlaceable?.width?.toDp() ?: 0.dp)
    val toolbarMeasurables = if (toolbar != null) {
      subcompose(slotId = SlotToolbar) { toolbar(toolbarPadding) }
    } else {
      emptyList()
    }
    val toolbarPlaceable = toolbarMeasurables.firstOrNull()?.measure(constraints)

    val contentPadding = PaddingValues(
      top = toolbarPlaceable?.height?.toDp() ?: 0.dp,
      start = navigationBarPlaceable?.width?.toDp() ?: 0.dp
    )
    val contentMeasurable = subcompose(slotId = SlotContent) { content(contentPadding) }
    val contentPlaceable = contentMeasurable.first().measure(constraints)

    return@SubcomposeLayout layout(width = constraints.maxWidth, height = constraints.maxHeight) {
      contentPlaceable.placeRelative(x = 0, y = 0)
      toolbarPlaceable?.placeRelative(x = 0, y = 0)
      navigationBarPlaceable?.placeRelative(x = 0, y = 0)
    }
  }
}

private const val SlotToolbar = "Toolbar"
private const val SlotNavigationBar = "NavigationBar"
private const val SlotContent = "Content"

// Preview

@Composable
internal fun NickelScreenPreview(modifier: Modifier = Modifier) {
  NickelTheme {
    NickelScreen(
      toolbar = { innerPadding ->
        NickelToolbarPreview(modifier = Modifier.padding(innerPadding))
      },
      navigationBar = { innerPadding ->
        NickelNavigationBarPreview(modifier = Modifier.padding(innerPadding))
      }
    ) { innerPadding ->
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(innerPadding)
      )
    }
  }
}

@NickelPreviewPhone
@Composable
private fun ScreenPreviewPhone() {
  NickelScreenPreview()
}

@NickelPreviewTablet
@Composable
private fun ScreenPreviewTablet() {
  NickelScreenPreview()
}
