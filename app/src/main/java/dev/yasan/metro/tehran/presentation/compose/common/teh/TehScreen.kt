package dev.yasan.metro.tehran.presentation.compose.common.teh

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.util.entity.Action
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper

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
    color: Color = colorResource(id = R.color.layer_foreground),
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    actions: List<Action> = emptyList(),
    state: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.layer_midground))
    ) {
        TehTitle(
            title = title,
            colorBackground = color,
            fontFamily = fontFamily,
            actions = actions
        )

        LazyColumn(
            modifier = Modifier
                .animateContentSize()
                .fillMaxWidth()
                .weight(1f),
            state = state,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}
