package com.sandhu.blinknews.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    // Using YOUR original colors
    primary = colorPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDAD6),
    onPrimaryContainer = colorPrimaryDark,

    secondary = colorAccent,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFD0E4FF),
    onSecondaryContainer = Color(0xFF001D36),

    tertiary = colorAccent,
    onTertiary = Color.White,

    background = background,

    surface = surface,
    onSurface = textPrimary,
    surfaceVariant = Color(0xFFE0E0E0),
    onSurfaceVariant = textSecondary,

    error = error,
    onError = Color.White,

    outline = divider,
    outlineVariant = Color(0xFFCAC4D0)
)

private val DarkColorScheme = darkColorScheme(
    // Using lighter versions of YOUR colors for dark mode
    primary = colorPrimaryDark_Night,
    onPrimary = Color.Black,
    primaryContainer = colorPrimaryDark,
    onPrimaryContainer = Color(0xFFFFDAD6),

    secondary = colorAccentDark_Night,
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF004A77),
    onSecondaryContainer = Color(0xFFD0E4FF),

    tertiary = colorAccentDark_Night,
    onTertiary = Color.Black,

    background = backgroundDark,
    onBackground = textPrimaryDark,

    surface = surfaceDark,
    onSurface = textPrimaryDark,
    surfaceVariant = Color(0xFF2C2C2C),
    onSurfaceVariant = textSecondaryDark,

    error = Color(0xFFCF6679),
    onError = Color.Black,

    outline = dividerDark,
    outlineVariant = Color(0xFF49454F)
)

@Composable
fun BlinkNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColors: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    // Update the system bars
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}