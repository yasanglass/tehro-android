package dev.yasan.metro.tehran.presentation.compose.common.teh

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.theme.dimenDivider

/**
 * Basic Tehro-themed divider. Should be used instead of the generic divider for easy theming.
 */
@Composable
fun TehDivider(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        color = colorResource(id = R.color.divider),
        thickness = dimenDivider
    )
}
