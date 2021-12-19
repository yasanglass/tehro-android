package dev.yasan.metro.tehran.ui.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.theme.TehroTheme

@Composable
fun TehroApp() {
    TehroTheme {
        Text(text = "Hello ${stringResource(id = R.string.app_name)}!")
    }
}

@Preview
@Composable
fun TehroAppPreview() {
    TehroApp()
}