package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.composables.icons.lucide.Image
import com.composables.icons.lucide.Lucide
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelIndicationPressStrength
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.nickelSizes
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.rememberNickelIndication
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.NickelPreviewPhone
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.NickelPreviewTablet
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ui
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.windowInsetsPartialPadding

@Composable
fun NickelNavigationBar(
  modifier: Modifier = Modifier,
  color: Color = MaterialTheme.colorScheme.surfaceContainer,
  contentColor: Color = MaterialTheme.colorScheme.onSurface,
  drawDivider: Boolean = true,
  content: @Composable NickelNavigationBarScope.() -> Unit
) {

  val screenType = getScreenType()

  when (screenType) {
    ScreenType.Phone -> PhoneNavigationBar(
      modifier = modifier,
      color = color,
      contentColor = contentColor,
      drawDivider = drawDivider,
      content = content
    )
    ScreenType.Tablet -> TabletNavigationBar(
      modifier = modifier,
      color = color,
      contentColor = contentColor,
      drawDivider = drawDivider,
      content = content
    )
  }
}

@Composable
private fun PhoneNavigationBar(
  color: Color,
  contentColor: Color,
  drawDivider: Boolean,
  modifier: Modifier = Modifier,
  content: @Composable NickelNavigationBarScope.() -> Unit
) {
  Column(modifier = modifier.fillMaxWidth()) {
    if (drawDivider) {
      HorizontalDivider()
    }

    NickelSurface(
      modifier = Modifier.fillMaxWidth(),
      color = color,
      contentColor = contentColor
    ) {
      PhoneNavigationBarLayout(
        color = color,
        contentColor = contentColor,
        modifier = Modifier
          .windowInsetsPartialPadding(
            windowInsets = WindowInsets.ui,
            bottom = true,
            start = true,
            end = true
          )
          .height(MaterialTheme.nickelSizes.navigationBar.height)
          .padding(vertical = MaterialTheme.nickelSizes.navigationBar.padding),
        content = content
      )
    }
  }
}

@Composable
private fun PhoneNavigationBarLayout(
  color: Color,
  contentColor: Color,
  modifier: Modifier = Modifier,
  content: @Composable NickelNavigationBarScope.() -> Unit
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.CenterVertically
  ) {
    val scopeParent = NickelNavigationBarScope.Parent.Row(scope = this)
    val scope = NickelNavigationBarScope(parent = scopeParent)
    content(scope)
  }
}

@Composable
private fun TabletNavigationBar(
  color: Color,
  contentColor: Color,
  drawDivider: Boolean,
  modifier: Modifier = Modifier,
  content: @Composable NickelNavigationBarScope.() -> Unit
) {
  Row(modifier = modifier.fillMaxHeight()) {
    NickelSurface(
      modifier = Modifier.fillMaxHeight(),
      color = color,
      contentColor = contentColor
    ) {
      TabletNavigationBarLayout(
        color = color,
        contentColor = contentColor,
        modifier = Modifier
          .windowInsetsPartialPadding(
            windowInsets = WindowInsets.ui,
            bottom = true,
            start = true,
            top = true
          )
          .width(MaterialTheme.nickelSizes.navigationBar.width)
          .padding(MaterialTheme.nickelSizes.navigationBar.padding),
        content = content
      )
    }

    if (drawDivider) {
      VerticalDivider()
    }
  }
}

@Composable
private fun TabletNavigationBarLayout(
  color: Color,
  contentColor: Color,
  modifier: Modifier = Modifier,
  content: @Composable NickelNavigationBarScope.() -> Unit
) {
  Column(
    modifier = modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.spacedBy(space = MaterialTheme.nickelSizes.navigationBar.spacing),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    val scopeParent = NickelNavigationBarScope.Parent.Column(scope = this)
    val scope = NickelNavigationBarScope(parent = scopeParent)
    content(scope)
  }
}

@LayoutScopeMarker
class NickelNavigationBarScope internal constructor(internal val parent: Parent) {
  internal sealed interface Parent {
    data class Row(val scope: RowScope) : Parent
    data class Column(val scope: ColumnScope) : Parent
  }

  @OptIn(ExperimentalMaterial3ExpressiveApi::class)
  @Composable
  fun Item(
    isChecked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
  ) {
    NickelSurface(
      onClick = onClick,
      modifier = modifier
        .height(MaterialTheme.nickelSizes.navigationBar.itemHeight)
        .width(MaterialTheme.nickelSizes.navigationBar.itemWidth),
      color = if (isChecked) MaterialTheme.colorScheme.primary else Color.Transparent,
      contentColor = if (isChecked) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary,
      shape = RoundedCornerShape(MaterialTheme.nickelSizes.cornerRadius.small),
      indication = rememberNickelIndication(pressStrength = NickelIndicationPressStrength.Soft)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(MaterialTheme.nickelSizes.navigationBar.itemPadding),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        NickelFixedSizeLayout(
          size = MaterialTheme.nickelSizes.navigationBar.iconSize,
          content = icon
        )

        CompositionLocalProvider(
          value = LocalTextStyle provides getItemTitleTextStyle(isChecked),
          content = text
        )
      }
    }
  }

  @Composable
  fun ItemsSpacer(modifier: Modifier = Modifier) {
    if (parent is Parent.Column) {
      with(parent.scope) {
        Spacer(modifier = modifier.weight(1f))
      }
    }
  }

  companion object {
    @Composable
    @ReadOnlyComposable
    private fun getItemTitleTextStyle(isChecked: Boolean): TextStyle {
      val screenType = getScreenType()
      val textStyle = when (screenType) {
        ScreenType.Phone -> MaterialTheme.typography.labelMedium
        ScreenType.Tablet -> MaterialTheme.typography.labelLarge
      }
      return textStyle.copy(
        fontWeight = if (isChecked) {
          FontWeight.Bold
        } else {
          FontWeight.Normal
        }
      )
    }
  }
}

// Preview

@Composable
internal fun NickelNavigationBarPreview(modifier: Modifier = Modifier) {
  NickelTheme {
    NickelNavigationBar {
      Item(
        text = { Text("Button") },
        icon = {
          Icon(
            imageVector = Lucide.Image,
            contentDescription = null
          )
        },
        isChecked = false,
        onClick = {}
      )
      Item(
        text = { Text("Button") },
        icon = {
          Icon(
            imageVector = Lucide.Image,
            contentDescription = null
          )
        },
        isChecked = false,
        onClick = {}
      )
      Item(
        text = { Text("Button") },
        icon = {
          Icon(
            imageVector = Lucide.Image,
            contentDescription = null
          )
        },
        isChecked = false,
        onClick = {}
      )

      ItemsSpacer()

      Item(
        text = { Text("Button") },
        icon = {
          Icon(
            imageVector = Lucide.Image,
            contentDescription = null
          )
        },
        isChecked = false,
        onClick = {}
      )
      Item(
        text = { Text("Button") },
        icon = {
          Icon(
            imageVector = Lucide.Image,
            contentDescription = null
          )
        },
        isChecked = false,
        onClick = {}
      )
    }
  }
}

@NickelPreviewPhone
@Composable
private fun NavigationBarPreviewPhone() {
  NickelNavigationBarPreview()
}

@NickelPreviewTablet
@Composable
private fun NavigationBarTablet() {
  NickelNavigationBarPreview()
}
