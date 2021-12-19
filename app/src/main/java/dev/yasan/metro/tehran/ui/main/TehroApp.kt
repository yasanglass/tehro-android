package dev.yasan.metro.tehran.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.ui.navigation.NavGraph
import dev.yasan.metro.tehran.ui.theme.TehroTheme

@ExperimentalAnimationApi
@Composable
fun TehroApp() {
    TehroTheme {
        NavGraph()
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun TehroAppPreview() {
    TehroApp()
}