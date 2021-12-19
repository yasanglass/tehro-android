package dev.yasan.metro.tehran.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.dp

private val dimenGrid = 8.dp
val dimenDivider = 1.dp
val dimenCorner = 8.dp

@Stable
fun grid(multiplier: Float) = dimenGrid * multiplier

@Stable
fun grid(multiplier: Int) = dimenGrid * multiplier

@Stable
fun grid() = dimenGrid