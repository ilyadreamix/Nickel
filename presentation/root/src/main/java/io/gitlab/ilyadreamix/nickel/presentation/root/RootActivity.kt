package io.gitlab.ilyadreamix.nickel.presentation.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.gitlab.ilyadreamix.nickel.presentation.common.R
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.ui.NickelScreen
import io.gitlab.ilyadreamix.nickel.presentation.common.ui.NickelToolbar
import android.graphics.Color as LegacyColor

class RootActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    enableEdgeToEdge(
      statusBarStyle = SystemBarStyle.auto(
        lightScrim = LegacyColor.TRANSPARENT,
        darkScrim = LegacyColor.TRANSPARENT
      ),
      navigationBarStyle = SystemBarStyle.auto(
        lightScrim = LegacyColor.TRANSPARENT,
        darkScrim = LegacyColor.TRANSPARENT
      )
    )

    super.onCreate(savedInstanceState)

    setContent {
      NickelTheme {
        NickelScreen(
          color = Color.Blue,
          contentColor = Color.White,
          toolbar = { innerPadding ->
            NickelToolbar(
              color = Color.Red,
              contentColor = Color.White,
              title = {
                Image(
                  painter = painterResource(R.drawable.presentation_common_app_logo),
                  contentDescription = null,
                  colorFilter = ColorFilter.tint(color = LocalContentColor.current),
                  modifier = Modifier.padding(16.dp)
                )
              }
            )
          }
        ) { innerPadding ->
          Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
          ) {
            Image(
              painter = painterResource(R.drawable.presentation_common_app_logo),
              contentDescription = null,
              colorFilter = ColorFilter.tint(color = LocalContentColor.current),
              modifier = Modifier.width(128.dp)
            )
          }
        }
      }
    }
  }
}
