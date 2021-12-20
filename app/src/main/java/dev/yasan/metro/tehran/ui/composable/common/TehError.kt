package dev.yasan.metro.tehran.ui.composable.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
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
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.rubikFamily
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper

@Composable
fun TehError(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.failed_to_load_data),
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    onRetry: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_midground))
            .padding(grid(2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title,
            fontFamily = fontFamily,
            color = colorResource(id = R.color.text_title),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        TehButton(
            title = stringResource(id = R.string.try_again),
            onClick = {
                onRetry()
            },
            fontFamily = fontFamily
        )

    }

}

@Preview(name = "TehError (En)", locale = "en")
@Composable
private fun TehErrorPreviewEn() {
    TehError(
        fontFamily = rubikFamily,
        onRetry = {}
    )
}

@Preview(name = "TehError (Fa)", locale = "fa")
@Composable
private fun TehErrorPreviewFa() {
    TehError(
        fontFamily = vazirFamily,
        onRetry = {}
    )
}