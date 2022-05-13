package dev.yasan.metro.tehran.presentation.util.helper.extension

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

/**
 * @return If the color is dark.
 *
 * @see luminance
 */
fun Color.isDark(): Boolean = luminance() < 0.5

/**
 * @return If the color is light.
 *
 * @see luminance
 */
fun Color.isLight(): Boolean = !this.isDark()

/**
 * @return Either black or white based on the luminosity of the color.
 *
 * @see isDark
 * @see isLight
 * @see luminance
 */
fun Color.getTextOnColor() = if (this.isDark()) Color.White else Color.Black
