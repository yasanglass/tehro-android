package dev.yasan.metro.tehran.model.misc

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Contains the data of a single action.
 */
data class Action(
    val iconModifier: Modifier = Modifier,
    val icon: ImageVector,
    val text: String,
    val onClick: () -> Unit
)