package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.nickelSizes
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType

@Composable
fun NickelScreen(
  modifier: Modifier = Modifier,
  toolbar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  navigationBar: (@Composable (innerPadding: PaddingValues) -> Unit)? = null,
  content: @Composable (innerPadding: PaddingValues) -> Unit,
) {

  val screenType = getScreenType()

  Surface(
    modifier = modifier,
    color = MaterialTheme.colorScheme.background,
    contentColor = MaterialTheme.colorScheme.onBackground
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

      contentPlaceable.place(x = 0, y = 0)

      if (navigationBarPlaceable != null) {
        val navigationBarPositionY = constraints.maxHeight - navigationBarPlaceable.height
        navigationBarPlaceable.place(x = 0, y = navigationBarPositionY)
      }

      toolbarPlaceable?.place(x = 0, y = 0)
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
      contentPlaceable.place(x = 0, y = 0)
      toolbarPlaceable?.place(x = 0, y = 0)
      navigationBarPlaceable?.placeRelative(x = 0, y = 0)
    }
  }
}

private const val SlotToolbar = "Toolbar"
private const val SlotNavigationBar = "NavigationBar"
private const val SlotContent = "Content"

@Preview(device = Devices.PHONE)
@Composable
private fun NickelScreenPreviewPhone() {
  NickelTheme {
    NickelScreen(
      toolbar = { innerPadding ->
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.nickelSizes.toolbar.height)
            .padding(innerPadding)
            .background(Color.Red)
        )
      },
      navigationBar = { innerPadding ->
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.nickelSizes.navigationBar.height)
            .padding(innerPadding)
            .background(Color.Blue)
        )
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

@Preview(device = Devices.TABLET)
@Composable
private fun NickelScreenPreviewTablet() {
  NickelTheme {
    NickelScreen(
      toolbar = { innerPadding ->
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.nickelSizes.toolbar.height)
            .padding(innerPadding)
            .background(Color.Red)
        )
      },
      navigationBar = { innerPadding ->
        Box(
          modifier = Modifier
            .fillMaxHeight()
            .width(MaterialTheme.nickelSizes.navigationBar.width)
            .padding(innerPadding)
            .background(Color.Blue)
        )
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
