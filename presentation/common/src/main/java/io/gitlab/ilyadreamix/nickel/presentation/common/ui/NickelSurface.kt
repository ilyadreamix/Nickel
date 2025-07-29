package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

@Composable
fun NickelSurface(
  modifier: Modifier = Modifier,
  color: Color = MaterialTheme.colorScheme.surface,
  contentColor: Color = MaterialTheme.colorScheme.onSurface,
  shape: Shape = RectangleShape,
  content: @Composable () -> Unit
) {
  Box(
    modifier = modifier.surface(color = color, shape = shape),
    propagateMinConstraints = true
  ) {
    CompositionLocalProvider(
      value = LocalContentColor provides contentColor,
      content = content
    )
  }
}

@Composable
fun NickelSurface(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  onLongClick: (() -> Unit)? = null,
  color: Color = MaterialTheme.colorScheme.surface,
  contentColor: Color = MaterialTheme.colorScheme.onSurface,
  shape: Shape = RectangleShape,
  indication: Indication? = null,
  interactionSource: MutableInteractionSource? = null,
  content: @Composable () -> Unit
) {

  val hapticFeedback = LocalHapticFeedback.current

  val finalIndication = indication ?: LocalIndication.current
  val finalInteractionSource = interactionSource ?: remember { MutableInteractionSource() }

  Box(
    modifier = modifier
      .combinedClickable(
        onClick = onClick,
        onLongClick = {
          if (onLongClick != null) {
            onLongClick()
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
          }
        },
        interactionSource = finalInteractionSource,
        indication = finalIndication
      )
      .surface(color = color, shape = shape),
    propagateMinConstraints = true
  ) {
    CompositionLocalProvider(
      value = LocalContentColor provides contentColor,
      content = content
    )
  }
}

private fun Modifier.surface(color: Color, shape: Shape) =
  background(color = color, shape = shape)
