package io.gitlab.ilyadreamix.nickel.presentation.root

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelTheme
import io.gitlab.ilyadreamix.nickel.presentation.common.theme.NickelThemeProvider

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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(NickelTheme.sizes.containerSpacing)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colors.background),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Background",
                                style = TextStyle(color = NickelTheme.colors.containerContent)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colors.container),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Container",
                                style = TextStyle(color = NickelTheme.colors.containerContent)
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
                                .background(NickelTheme.colors.containerContent),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Container Content",
                                style = TextStyle(color = NickelTheme.colors.container)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colors.outline),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Outline",
                                style = TextStyle(color = NickelTheme.colors.container)
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
                                .background(NickelTheme.colors.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Primary",
                                style = TextStyle(color = NickelTheme.colors.primaryContent)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(64.dp)
                                .clip(NickelTheme.shapes.container)
                                .background(NickelTheme.colors.primaryContent),
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Primary Content",
                                style = TextStyle(color = NickelTheme.colors.primary)
                            )
                        }
                    }
                }
            }
        }
    }
}
