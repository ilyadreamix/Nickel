package io.gitlab.ilyadreamix.nickel.presentation.common.utility

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
  device = Devices.PHONE,
  uiMode = Configuration.UI_MODE_NIGHT_YES
)
internal annotation class NickelPreviewPhone

@Preview(
  device = Devices.TABLET,
  uiMode = Configuration.UI_MODE_NIGHT_YES
)
internal annotation class NickelPreviewTablet
