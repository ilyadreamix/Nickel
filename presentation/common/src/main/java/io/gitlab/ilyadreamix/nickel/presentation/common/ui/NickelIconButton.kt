package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelIndicationPressStrength
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.nickelSizes
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.rememberNickelIndication

@Composable
fun NickelIconButton(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  NickelSurface(
    onClick = onClick,
    modifier = modifier.size(MaterialTheme.nickelSizes.iconButton.containerSize),
    indication = rememberNickelIndication(pressStrength = NickelIndicationPressStrength.Normal)
  ) {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      NickelFixedSizeLayout(
        size = MaterialTheme.nickelSizes.iconButton.size,
        content = content
      )
    }
  }
}
