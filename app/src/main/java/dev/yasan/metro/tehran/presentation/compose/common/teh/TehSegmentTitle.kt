package dev.yasan.metro.tehran.presentation.compose.common.teh

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * Tehro-themed segment title. Similar to [TehTitle] but has no background.
 * Unlike [TehTitle], this is used between the actual screen content.
 */
@Composable
fun TehSegmentTitle(
    modifier: Modifier = Modifier,
    title: String,
    paddingTop: Dp = grid(2),
    paddingBottom: Dp = grid(2),
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = paddingTop, bottom = paddingBottom),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title.uppercase(),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 18.sp,
            color = colorResource(id = R.color.text_title),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(name = "Teh Segment Title (En)", locale = "en")
@Composable
private fun TehSegmentTitlePreviewEn() {
    Surface(color = colorResource(id = R.color.layer_foreground)) {
        TehSegmentTitle(title = stringResource(id = R.string.lines), fontFamily = rubikFamily)
    }
}

@Preview(name = "Teh Segment Title (Fa)", locale = "fa")
@Composable
private fun TehSegmentTitlePreviewFa() {
    Surface(color = colorResource(id = R.color.layer_foreground)) {
        TehSegmentTitle(title = stringResource(id = R.string.lines), fontFamily = vazirFamily)
    }
}
