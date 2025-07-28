package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.util.fastFirstOrNull
import com.composables.icons.lucide.Check
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Share
import io.gitlab.ilyadreamix.nickel.presentation.common.lucide.NavigateBack
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.nickelSizes
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.NickelPreviewPhone
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.NickelPreviewTablet
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ui
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.windowInsetsPartialPadding

@Composable
fun NickelToolbar(
  modifier: Modifier = Modifier,
  color: Color = MaterialTheme.colorScheme.surface,
  contentColor: Color = MaterialTheme.colorScheme.onSurface,
  leadingActions: (@Composable RowScope.() -> Unit)? = null,
  title: (@Composable () -> Unit)? = null,
  trailingActions: (@Composable RowScope.() -> Unit)? = null,
  ignoreStartInsets: Boolean = false
) {

  val screenType = getScreenType()

  NickelSurface(
    modifier = modifier.fillMaxWidth(),
    color = color,
    contentColor = contentColor
  ) {
    val leadingActionsContent: (@Composable (Modifier) -> Unit)? = if (leadingActions == null) null else { innerModifier ->
      ToolbarActions(
        modifier = innerModifier,
        content = leadingActions
      )
    }

    val titleContent: (@Composable (Modifier) -> Unit)? = if (title == null) null else { innerModifier ->
      Box(modifier = innerModifier.wrapContentSize()) {
        CompositionLocalProvider(
          value = LocalTextStyle provides TitleTextStyle,
          content = title
        )
      }
    }

    val trailingActions: (@Composable (Modifier) -> Unit)? = if (trailingActions == null) null else { innerModifier ->
      ToolbarActions(
        modifier = innerModifier,
        content = trailingActions
      )
    }

    ToolbarLayout(
      modifier = Modifier
        .windowInsetsPartialPadding(
          windowInsets = WindowInsets.ui,
          top = true,
          start = ignoreStartInsets && screenType == ScreenType.Tablet,
          end = true
        )
        .height(MaterialTheme.nickelSizes.toolbar.height)
        .padding(
          vertical = MaterialTheme.nickelSizes.toolbar.verticalPadding,
          horizontal = MaterialTheme.nickelSizes.toolbar.horizontalPadding
        ),
      leadingActions = leadingActionsContent,
      title = titleContent,
      trailingActions = trailingActions
    )
  }
}

@Composable
private fun ToolbarLayout(
  modifier: Modifier = Modifier,
  title: (@Composable (innerModifier: Modifier) -> Unit)?,
  leadingActions: (@Composable (innerModifier: Modifier) -> Unit)?,
  trailingActions: (@Composable (innerModifier: Modifier) -> Unit)?,
) {
  Layout(
    modifier = modifier.fillMaxWidth(),
    content = {
      if (leadingActions != null) {
        val innerModifier = Modifier.layoutId(LayoutIdLeadingActions)
        leadingActions(innerModifier)
      }

      if (title != null) {
        val innerModifier = Modifier.layoutId(LayoutIdTitle)
        title(innerModifier)
      }

      if (trailingActions != null) {
        val innerModifier = Modifier.layoutId(LayoutIdTrailingActions)
        trailingActions(innerModifier)
      }
    }
  ) { measurables, constraints ->
    val titlePlaceable = measurables
      .fastFirstOrNull { measurable -> measurable.layoutId == LayoutIdTitle }
      ?.measure(constraints)

    val actionsConstraints = if (titlePlaceable != null) {
      val totalMaxWidth = constraints.maxWidth - (titlePlaceable.width / 2)
      constraints.copy(maxWidth = totalMaxWidth / 2, minWidth = 0)
    } else {
      constraints
    }

    val leadingActionsPlaceable = measurables
      .fastFirstOrNull { measurable -> measurable.layoutId == LayoutIdLeadingActions }
      ?.measure(actionsConstraints)

    val trailingActionsPlaceable = measurables
      .fastFirstOrNull { measurable -> measurable.layoutId == LayoutIdTrailingActions }
      ?.measure(actionsConstraints)

    return@Layout layout(width = constraints.maxWidth, height = constraints.maxHeight) {
      if (leadingActionsPlaceable != null) {
        val positionY = (constraints.maxHeight - leadingActionsPlaceable.height) / 2
        leadingActionsPlaceable.placeRelative(x = 0, y = positionY)
      }

      if (titlePlaceable != null) {
        val positionX = (constraints.maxWidth / 2) - (titlePlaceable.width / 2)
        val positionY = (constraints.maxHeight - titlePlaceable.height) / 2
        titlePlaceable.placeRelative(x = positionX, y = positionY)
      }

      if (trailingActionsPlaceable != null) {
        val positionX = constraints.maxWidth - trailingActionsPlaceable.width
        val positionY = (constraints.maxHeight - trailingActionsPlaceable.height) / 2
        trailingActionsPlaceable.placeRelative(x = positionX, y = positionY)
      }
    }
  }
}

@Composable
private fun ToolbarActions(
  modifier: Modifier = Modifier,
  content: @Composable RowScope.() -> Unit
) {
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    content = content
  )
}

private const val LayoutIdLeadingActions = "LeadingActions"
private const val LayoutIdTitle = "Title"
private const val LayoutIdTrailingActions = "TrailingActions"

private val TitleTextStyle
  @Composable
  @ReadOnlyComposable
  get(): TextStyle {
    val screenType = getScreenType()
    val style = when (screenType) {
      ScreenType.Phone -> MaterialTheme.typography.titleLarge
      ScreenType.Tablet -> MaterialTheme.typography.headlineSmall
    }
    return style.copy(textAlign = TextAlign.Center)
  }

// Preview

@Composable
internal fun NickelToolbarPreview(modifier: Modifier = Modifier) {
  NickelTheme {
    NickelToolbar(
      modifier = modifier,
      leadingActions = {
        NickelIconButton(onClick = {}) {
          Icon(
            imageVector = Lucide.NavigateBack,
            contentDescription = null
          )
        }
      },
      title = {
        Text(text = "NickelToolbar")
      },
      trailingActions = {
        NickelIconButton(onClick = {}) {
          Icon(
            imageVector = Lucide.Share,
            contentDescription = null
          )
        }

        NickelIconButton(onClick = {}) {
          Icon(
            imageVector = Lucide.Check,
            contentDescription = null
          )
        }
      },
      ignoreStartInsets = true
    )
  }
}

@NickelPreviewPhone
@Composable
private fun ToolbarPreviewPhone() {
  NickelToolbarPreview()
}

@NickelPreviewTablet
@Composable
private fun ToolbarPreviewTablet() {
  NickelToolbarPreview()
}
