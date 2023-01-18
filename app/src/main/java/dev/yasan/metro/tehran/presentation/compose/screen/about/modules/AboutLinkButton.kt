package dev.yasan.metro.tehran.presentation.compose.screen.about.modules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.screen.about.AboutScreen
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.core.WebHelper

/**
 * A simple composable that shows a clickable icon. Meant to be used on [AboutScreen].
 */
@Composable
fun AboutLinkButton(
    icon: Painter,
    url: String,
    contentDescription: String,
) {
    val context = LocalContext.current
    if (url.isNotBlank() && WebHelper.isStringURL(string = url)) {
        Icon(
            icon,
            contentDescription = contentDescription,
            tint = colorResource(id = R.color.text_title),
            modifier = Modifier
                .padding(grid())
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false)
                ) {
                    WebHelper.openWebView(context = context, url = url)
                }
                .padding(grid())
        )
    }
}

/**
 * A simple composable that shows a clickable icon. Meant to be used on [AboutScreen].
 */
@Composable
fun AboutLinkButton(
    icon: ImageVector,
    url: String,
    contentDescription: String,
) {
    if (url.isNotBlank() && WebHelper.isStringURL(string = url)) {
        val context = LocalContext.current
        Icon(
            icon,
            contentDescription = contentDescription,
            tint = colorResource(id = R.color.text_title),
            modifier = Modifier
                .padding(grid())
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false)
                ) {
                    WebHelper.openWebView(context = context, url = url)
                }
                .padding(grid())
        )
    }
}
