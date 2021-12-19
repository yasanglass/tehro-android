package dev.yasan.metro.tehran.ui.composable.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.R

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.app_name))
    }
}

@Preview(name = "Home Screen")
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}