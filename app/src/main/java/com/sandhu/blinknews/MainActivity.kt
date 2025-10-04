package com.sandhu.blinknews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.sandhu.blinknews.domain.usecases.AppEntryUseCases
import com.sandhu.blinknews.presentation.onboarding.OnBoardingScreen
import com.sandhu.blinknews.ui.theme.BlinkNewsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCase: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        lifecycleScope.launch {
            appEntryUseCase.readAppEntry().collect {
                Log.d("test", it.toString())
                if (it) {
                    //Navigate to Home
                } else {
                    //Navigate to OnBoarding
                }
            }
        }
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