package dev.yasan.metro.tehran.ui.composable.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.R

@Preview
@Composable
fun TehProgress(modifier: Modifier = Modifier) {
    LinearProgressIndicator(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.layer_background),
        color = colorResource(id = R.color.theme_accent)
    )
}