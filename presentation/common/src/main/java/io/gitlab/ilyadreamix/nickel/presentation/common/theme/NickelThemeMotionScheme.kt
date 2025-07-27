package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MotionScheme

@Suppress("UNCHECKED_CAST")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
internal object NickelThemeMotionScheme : MotionScheme {
  private const val AnimationDurationFast = 200
  private const val AnimationDurationDefault = 300
  private const val AnimationDurationSlow = 400

  val fastSpec = tween<Any>(durationMillis = AnimationDurationFast)
  val defaultSpec = tween<Any>(durationMillis = AnimationDurationDefault)
  val slowSpec = tween<Any>(durationMillis = AnimationDurationSlow)

  override fun <T> fastSpatialSpec() = fastSpec as FiniteAnimationSpec<T>
  override fun <T> defaultSpatialSpec() = defaultSpec as FiniteAnimationSpec<T>
  override fun <T> slowSpatialSpec() = slowSpec as FiniteAnimationSpec<T>

  override fun <T> fastEffectsSpec() = fastSpec as FiniteAnimationSpec<T>
  override fun <T> defaultEffectsSpec() = defaultSpec as FiniteAnimationSpec<T>
  override fun <T> slowEffectsSpec() = slowSpec as FiniteAnimationSpec<T>
}
