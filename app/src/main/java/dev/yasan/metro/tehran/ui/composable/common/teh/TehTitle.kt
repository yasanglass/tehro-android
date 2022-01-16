package dev.yasan.metro.tehran.ui.composable.common.teh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.themePrimary
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.extension.getTextOnColor

/**
 * Tehro-themed screen title.
 * This composable must be used on top of every single screen.
 */
@Composable
fun TehTitle(
    modifier: Modifier = Modifier,
    title: String,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    colorBackground: Color = themePrimary,
    colorText: Color = colorBackground.getTextOnColor()
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorBackground)
            .padding(grid(2)),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title.uppercase(),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 18.sp,
            color = colorText,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(name = "Teh Title (En)", locale = "en")
@Composable
private fun TehTitlePreviewEn() {
    TehTitle(title = stringResource(id = R.string.app_name))
}

@Preview(name = "Teh Title (Fa)", locale = "fa")
@Composable
private fun TehTitlePreviewFa() {
    TehTitle(title = stringResource(id = R.string.app_name), fontFamily = vazirFamily)
}
