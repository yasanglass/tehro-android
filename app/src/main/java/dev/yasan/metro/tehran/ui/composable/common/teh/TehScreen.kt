package dev.yasan.metro.tehran.ui.composable.common.teh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.theme.themePrimary
import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * Tehro-themed screen.
 * This composable presents your [content] in a standard Tehro screen.
 * All navigation routes must use this wrapper unless they do not require vertical scroll.
 *
 * @see TehSegmentTitle
 */
@Composable
fun TehScreen(
    title: String,
    color: Color = themePrimary,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    content: LazyListScope.() -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.layer_midground))
    ) {

        TehTitle(title = title, colorBackground = color, fontFamily = fontFamily)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            content()
        }
    }
}
