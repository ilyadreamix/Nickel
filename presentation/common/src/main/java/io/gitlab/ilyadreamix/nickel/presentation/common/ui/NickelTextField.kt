package io.gitlab.ilyadreamix.nickel.presentation.common.ui

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun NickelTextField(
  value: TextFieldValue,
  onValueChange: (TextFieldValue) -> Unit,
  modifier: Modifier = Modifier
) {
  BasicTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier
  )
}
