package com.music.spotui.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val TuneStreamColorScheme = darkColorScheme(
    primary = TunePurple,
    onPrimary = TuneText,
    primaryContainer = TunePurpleDim,
    onPrimaryContainer = TuneText,

    secondary = TuneTeal,
    onSecondary = TuneBlack,
    secondaryContainer = TuneTealDim,
    onSecondaryContainer = TuneText,

    tertiary = TunePurpleLight,
    onTertiary = TuneBlack,

    background = TuneBlack,
    onBackground = TuneText,

    surface = TuneSurface,
    onSurface = TuneText,
    surfaceVariant = TuneSurfaceAlt,
    onSurfaceVariant = TuneTextMuted,

    outline = TuneOutline,
    outlineVariant = TuneOutline,

    error = TuneError,
    onError = TuneText
)

@Composable
fun TuneStreamTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = TuneBlack.toArgb()
            window.navigationBarColor = TuneBlack.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = TuneStreamColorScheme,
        typography = TuneStreamTypography,
        shapes = TuneStreamShapes,
        content = content
    )
}
