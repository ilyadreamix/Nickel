package com.composables.icons.lucide

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

@Suppress("UnusedReceiverParameter")
val Lucide.MoveStart
  @Composable
  @ReadOnlyComposable
  get() = if (LocalLayoutDirection.current == LayoutDirection.Ltr) {
    Lucide.MoveLeft
  } else {
    Lucide.MoveRight
  }
