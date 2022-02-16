package dev.yasan.metro.tehran.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.dp

private val dimenGrid = 8.dp
val dimenDivider = 2.dp

/**
 * @return The base grid size multiplied by [multiplier].
 */
@Stable
fun grid(multiplier: Float) = dimenGrid * multiplier

/**
 * @return The base grid size multiplied by [multiplier].
 */
@Stable
fun grid(multiplier: Int) = dimenGrid * multiplier

/**
 * @return The base grid size.
 */
@Stable
fun grid() = dimenGrid
