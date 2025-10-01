package com.sandhu.blinknews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.sandhu.blinknews.presentation.onboarding.OnBoardingScreen
import com.sandhu.blinknews.ui.theme.BlinkNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            BlinkNewsTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                OnBoardingScreen()
                }
            }
        }
    }
}