package io.gitlab.ilyadreamix.nickel.presentation.common.lucide

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.MoveLeft
import com.composables.icons.lucide.MoveRight

@Suppress("UnusedReceiverParameter")
val Lucide.NavigateBack
  @Composable
  @ReadOnlyComposable
  get() = if (LocalLayoutDirection.current == LayoutDirection.Ltr) {
    Lucide.MoveLeft
  } else {
    Lucide.MoveRight
  }
