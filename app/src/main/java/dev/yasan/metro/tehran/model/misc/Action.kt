package dev.yasan.metro.tehran.model.misc

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Contains the data of a single action.
 */
data class Action(
    val icon: ImageVector,
    val text: String,
    val onClick: () -> Unit
)