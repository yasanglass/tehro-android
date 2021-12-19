package dev.yasan.metro.tehran.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

/**
 * @return If the color is dark.
 */
fun Color.isDark(): Boolean = luminance() < 0.5

/**
 * @return If the color is light.
 */
fun Color.isLight(): Boolean = !this.isDark()

/**
 * @return Either black or white based on the luminosity of the color.
 */
fun Color.getTextOnColor() = if (this.isDark()) Color.White else Color.Black
