package dev.yasan.metro.tehran.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.navigation.NavGraph
import dev.yasan.metro.tehran.ui.theme.TehroTheme

@ExperimentalAnimationApi
@Composable
fun TehroApp() {
    TehroTheme {
        Surface(color = colorResource(id = R.color.layer_midground)) {
            NavGraph()
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun TehroAppPreview() {
    TehroApp()
}