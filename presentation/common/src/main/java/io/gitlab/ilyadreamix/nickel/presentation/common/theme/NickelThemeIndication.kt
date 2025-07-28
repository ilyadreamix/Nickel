package io.gitlab.ilyadreamix.nickel.presentation.common.theme

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

enum class NickelIndicationPressStrength(internal val value: Float) {
  Normal(0.75f),
  Soft(0.85f),
  Hard(0.5f);
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun rememberNickelIndication(
  pressStrength: NickelIndicationPressStrength = NickelIndicationPressStrength.Normal,
  fadeOnPress: Boolean = true,
  animationSpec: AnimationSpec<Float> = MaterialTheme.motionScheme.defaultEffectsSpec()
): IndicationNodeFactory {
  return remember(pressStrength, animationSpec, fadeOnPress) {
    ScaleIndicationNodeFactory(
      animationSpec = animationSpec,
      pressedScale = pressStrength.value,
      fadeOnPress = fadeOnPress
    )
  }
}

@Stable
private class ScaleIndicationNodeFactory(
  private val animationSpec: AnimationSpec<Float>,
  private val pressedScale: Float,
  private val fadeOnPress: Boolean,
) : IndicationNodeFactory {

  override fun create(interactionSource: InteractionSource): DelegatableNode =
    ScaleIndicationNode(
      interactionSource = interactionSource,
      animationSpec = animationSpec,
      pressedScale = pressedScale,
      fadeOnPress = fadeOnPress
    )

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as ScaleIndicationNodeFactory

    if (pressedScale != other.pressedScale) return false
    if (fadeOnPress != other.fadeOnPress) return false
    if (animationSpec != other.animationSpec) return false

    return true
  }

  override fun hashCode(): Int {
    var result = pressedScale.hashCode()
    result = 31 * result + fadeOnPress.hashCode()
    result = 31 * result + animationSpec.hashCode()
    return result
  }
}

private class ScaleIndicationNode(
  private val interactionSource: InteractionSource,
  private val animationSpec: AnimationSpec<Float>,
  private val pressedScale: Float,
  private val fadeOnPress: Boolean
) : Modifier.Node(), DrawModifierNode {

  private val scaleAnimatable = Animatable(1f)
  private val alphaAnimatable = Animatable(1f)

  private suspend fun animateToPressed() = coroutineScope {
    val jobs = mutableListOf<Job>()
    jobs += launch { scaleAnimatable.animateTo(targetValue = pressedScale, animationSpec = animationSpec) }

    if (fadeOnPress) {
      jobs += launch { alphaAnimatable.animateTo(targetValue = 0.75f, animationSpec = animationSpec) }
    }

    jobs.joinAll()
  }

  private suspend fun animateToReleased() = coroutineScope {
    val jobs = mutableListOf<Job>()
    jobs += launch { scaleAnimatable.animateTo(targetValue = 1f, animationSpec = animationSpec) }

    if (fadeOnPress) {
      jobs += launch { alphaAnimatable.animateTo(targetValue = 1f, animationSpec = animationSpec) }
    }

    jobs.joinAll()
  }

  override fun onAttach() {
    coroutineScope.launch {
      interactionSource.interactions.collectLatest { interaction ->
        when (interaction) {
          is PressInteraction.Press -> animateToPressed()
          is PressInteraction.Release -> animateToReleased()
          is PressInteraction.Cancel -> animateToReleased()
        }
      }
    }
  }

  override fun ContentDrawScope.draw() {
    drawContext.canvas.saveLayer(
      bounds = Rect(0f, 0f, size.width, size.height),
      paint = Paint().apply { alpha = alphaAnimatable.value }
    )

    scale(scaleAnimatable.value, scaleAnimatable.value) {
      this@draw.drawContent()
    }

    drawContext.canvas.restore()
  }
}
