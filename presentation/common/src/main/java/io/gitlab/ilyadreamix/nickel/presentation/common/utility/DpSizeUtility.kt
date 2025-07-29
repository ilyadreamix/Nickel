@file:Suppress("NOTHING_TO_INLINE")

package io.gitlab.ilyadreamix.nickel.presentation.common.utility

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize

@Stable
inline infix fun Dp.withHeight(height: Dp) = DpSize(this, height)

@Stable
inline infix fun Dp.withWidth(width: Dp) = DpSize(width, this)

@Stable
inline val Dp.square get() = DpSize(this, this)
