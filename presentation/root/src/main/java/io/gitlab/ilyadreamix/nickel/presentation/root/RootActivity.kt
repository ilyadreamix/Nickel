package io.gitlab.ilyadreamix.nickel.presentation.root

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelThemeProvider
import io.gitlab.ilyadreamix.nickel.presentation.common.R

class RootActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.auto(
                lightScrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT
            )
        )

        setContent {
            NickelThemeProvider {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .padding(NickelTheme.sizes.screenPadding),
                    verticalArrangement = Arrangement.spacedBy(NickelTheme.sizes.containerSpacing)
                ) {
                    Image(
                        painter = painterResource(R.drawable.presentation_common_app_logo),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = NickelTheme.colorScheme.containerContent),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(128.dp)
                    )

                    BasicText(
                        text = "Colors test",
                        style = TextStyle(
                            color = NickelTheme.colorScheme.containerContent,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = NickelTheme.sizes.containerSpacing * 4)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(NickelTheme.sizes.containerSpacing)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colorScheme.background),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Background",
                                style = TextStyle(color = NickelTheme.colorScheme.containerContent)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colorScheme.container),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Container",
                                style = TextStyle(color = NickelTheme.colorScheme.containerContent)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(NickelTheme.sizes.containerSpacing)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colorScheme.containerContent),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Container Content",
                                style = TextStyle(color = NickelTheme.colorScheme.container)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colorScheme.outline),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Outline",
                                style = TextStyle(color = NickelTheme.colorScheme.container)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(NickelTheme.sizes.containerSpacing)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Primary",
                                style = TextStyle(color = NickelTheme.colorScheme.primaryContent)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colorScheme.primaryContent),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Primary Content",
                                style = TextStyle(color = NickelTheme.colorScheme.primary)
                            )
                        }
                    }
                }
            }
        }
    }
}
