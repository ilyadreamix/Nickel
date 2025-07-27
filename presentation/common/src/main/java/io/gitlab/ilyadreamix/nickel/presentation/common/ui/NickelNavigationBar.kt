package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.nickelSizes
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.ScreenType
import io.gitlab.ilyadreamix.nickel.presentation.common.utility.getScreenType

@Composable
internal fun NickelNavigationBarPreview(modifier: Modifier = Modifier) {

  val screenType = getScreenType()

  when (screenType) {
    ScreenType.Phone -> Box(
      modifier = modifier
        .fillMaxWidth()
        .height(MaterialTheme.nickelSizes.navigationBar.height)
        .then(modifier)
        .background(Color.Blue)
    )
    ScreenType.Tablet -> Box(
      modifier = modifier
        .fillMaxHeight()
        .width(MaterialTheme.nickelSizes.navigationBar.width)
        .background(Color.Blue)
    )
  }
}
