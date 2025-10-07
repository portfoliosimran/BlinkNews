package com.sandhu.blinknews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sandhu.blinknews.presentation.nvgraph.NavGraph
import com.sandhu.blinknews.ui.theme.BlinkNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }
        }
        setContent {
            BlinkNewsTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }

                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.light(
                        Color.Transparent.hashCode(),
                        Color.Transparent.hashCode()
                    ),
                    navigationBarStyle = SystemBarStyle.light(
                        Color.Transparent.hashCode(),
                        Color.Transparent.hashCode()
                    )
                )
            }
        }
    }
}