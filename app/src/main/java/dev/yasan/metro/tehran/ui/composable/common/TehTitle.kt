package dev.yasan.metro.tehran.ui.composable.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.theme.Purple200
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper

@Composable
fun TehTitle(
    modifier: Modifier = Modifier,
    title: String,
    fontFamily: FontFamily = LocaleHelper.properFontFamily
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Purple200)
            .padding(grid(2))
    ) {
        Text(
            text = title,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview(name = "Teh Title (En)", locale = "en")
@Composable
fun TehTitlePreviewEn() {
    TehTitle(title = stringResource(id = R.string.app_name))
}

@Preview(name = "Teh Title (Fa)", locale = "fa")
@Composable
fun TehTitlePreviewFa() {
    TehTitle(title = stringResource(id = R.string.app_name), fontFamily = vazirFamily)
}