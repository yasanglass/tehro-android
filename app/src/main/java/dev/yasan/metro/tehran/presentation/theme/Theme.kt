package dev.yasan.metro.tehran.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = themePrimary,
    primaryVariant = themePrimaryDark,
    secondary = themePrimary,
    secondaryVariant = themePrimaryDark
)

private val LightColorPalette = lightColors(
    primary = themePrimary,
    primaryVariant = themePrimaryDark,
    secondary = themePrimary,
    secondaryVariant = themePrimaryDark

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

/**
 * Tehro theme in Compose.
 * This is not much used as currently the legacy(?) resources system is much more powerful.
 */
@Composable
fun TehroTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
