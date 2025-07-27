package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType

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

  Surface(
    modifier = modifier,
    color = color,
    contentColor = contentColor
  ) {
    when (screenType) {
      ScreenType.Phone -> PhoneScreen(
        toolbar = toolbar,
        navigationBar = navigationBar,
        content = content
      )
      ScreenType.Tablet -> TabletScreen(
        toolbar = toolbar,
        navigationBar = navigationBar,
        content = content
      )
    }
  }
}

@Composable
private fun PhoneScreen(
  modifier: Modifier = Modifier,
  toolbar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  navigationBar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  content: @Composable (innerPadding: PaddingValues) -> Unit,
) {
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
      bottom = navigationBarPlaceable?.height?.toDp() ?: 0.dp
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
private fun TabletScreen(
  modifier: Modifier = Modifier,
  toolbar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  navigationBar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  content: @Composable (innerPadding: PaddingValues) -> Unit,
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
          .background(Color.Green)
      )
    }
  }
}

@Preview(device = Devices.PHONE)
@Composable
private fun ScreenPreviewPhone() {
  NickelScreenPreview()
}

@Preview(device = Devices.TABLET)
@Composable
private fun ScreenPreviewTablet() {
  NickelScreenPreview()
}
