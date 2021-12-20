package dev.yasan.metro.tehran.ui.composable.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.theme.*
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.getTextOnColor

@Composable
fun TehButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    isFarsi: Boolean = LocaleHelper.isFarsi
) {
    @Composable
    fun IconComposable() {
        Icon(
            imageVector = TehroIcons.Refresh,
            contentDescription = null,
            tint = colorResource(id = R.color.text_title),
        )
    }
    Row(
        modifier = modifier
            .background(color = themeAccent)
            .clickable {
                onClick()
            }
            .padding(vertical = grid(1))
            .padding(horizontal = grid(2)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!isFarsi) {
            IconComposable()
            Spacer(modifier = Modifier.requiredWidth(grid()))
        }
        Text(
            text = title.uppercase(),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = themeAccent.getTextOnColor(),
            textAlign = TextAlign.Center
        )
        if (isFarsi) {
            Spacer(modifier = Modifier.requiredWidth(grid()))
            IconComposable()
        }
    }
}

@Preview(name = "TehButton (En)", locale = "en")
@Composable
private fun TehButtonPreviewEn() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(id = R.string.try_again),
            onClick = {},
            fontFamily = rubikFamily,
        )
    }
}

@Preview(name = "TehButton (Fa)", locale = "fa")
@Composable
private fun TehButtonPreviewFa() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(id = R.string.try_again),
            onClick = {},
            fontFamily = vazirFamily,
        )
    }
}