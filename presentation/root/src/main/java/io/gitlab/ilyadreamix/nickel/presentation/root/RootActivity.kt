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
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.composables.icons.lucide.Check
import com.composables.icons.lucide.Image
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Share
import io.gitlab.ilyadreamix.nickel.presentation.common.R
import io.gitlab.ilyadreamix.nickel.presentation.common.lucide.NavigateBack
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.ui.NickelIconButton
import io.gitlab.ilyadreamix.nickel.presentation.common.ui.NickelNavigationBar
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

      val checkedIndex = remember { mutableIntStateOf(0) }

      NickelTheme {
        NickelScreen(
          toolbar = { innerPadding ->
            NickelToolbar(
              modifier = Modifier.padding(innerPadding),
              leadingActions = {
                NickelIconButton(onClick = {}) {
                  Icon(
                    imageVector = Lucide.NavigateBack,
                    contentDescription = null
                  )
                }
              },
              title = {
                Image(
                  painter = painterResource(R.drawable.presentation_common_app_logo),
                  contentDescription = null,
                  colorFilter = ColorFilter.tint(color = LocalContentColor.current),
                  modifier = Modifier.padding(16.dp)
                )
              },
              trailingActions = {
                NickelIconButton(onClick = {}) {
                  Icon(
                    imageVector = Lucide.Share,
                    contentDescription = null
                  )
                }

                NickelIconButton(onClick = {}) {
                  Icon(
                    imageVector = Lucide.Check,
                    contentDescription = null
                  )
                }
              }
            )
          },
          navigationBar = {
            NickelNavigationBar {
              Item(
                text = { Text("Button") },
                icon = {
                  Icon(
                    imageVector = Lucide.Image,
                    contentDescription = null
                  )
                },
                isChecked = checkedIndex.intValue == 0,
                onClick = { checkedIndex.intValue = 0 }
              )
              Item(
                text = { Text("Button") },
                icon = {
                  Icon(
                    imageVector = Lucide.Image,
                    contentDescription = null
                  )
                },
                isChecked = checkedIndex.intValue == 1,
                onClick = { checkedIndex.intValue = 1 },
              )
              Item(
                text = { Text("Button") },
                icon = {
                  Icon(
                    imageVector = Lucide.Image,
                    contentDescription = null
                  )
                },
                isChecked = checkedIndex.intValue == 2,
                onClick = { checkedIndex.intValue = 2 },
              )

              ItemsSpacer()

              Item(
                text = { Text("Button") },
                icon = {
                  Icon(
                    imageVector = Lucide.Image,
                    contentDescription = null
                  )
                },
                isChecked = checkedIndex.intValue == 3,
                onClick = { checkedIndex.intValue = 3 },
              )
              Item(
                text = { Text("Button") },
                icon = {
                  Icon(
                    imageVector = Lucide.Image,
                    contentDescription = null
                  )
                },
                isChecked = checkedIndex.intValue == 4,
                onClick = { checkedIndex.intValue = 4 },
              )
            }
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
