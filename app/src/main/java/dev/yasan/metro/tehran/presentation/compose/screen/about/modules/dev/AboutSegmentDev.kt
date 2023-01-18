package dev.yasan.metro.tehran.presentation.compose.screen.about.modules.dev

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.screen.about.AboutScreen
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.components.YasanBrandingFooter
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * A segment of [AboutScreen] that shows information about the app's developer.
 */
@Composable
fun AboutSegmentDev(fontFamily: FontFamily = LocaleHelper.properFontFamily) {
    Column(
        modifier = Modifier.background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        YasanBrandingFooter(spacerTop = 0.dp, spacerBottom = 0.dp)

        Text(
            modifier = Modifier.padding(grid(2)),
            text = stringResource(R.string.about_yasan),
            fontFamily = fontFamily,
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_title),
            textAlign = TextAlign.Center
        )

        Divider(modifier = Modifier.background(color = colorResource(id = R.color.divider)))
    }
}

@Preview("About Dev [en]", group = "light", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About Dev [en]", group = "dark", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentDevPreviewEn() {
    AboutSegmentDev(fontFamily = rubikFamily)
}

@Preview("About Dev [fa]", group = "light", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About Dev [fa]", group = "dark", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentDevPreviewFa() {
    AboutSegmentDev(fontFamily = vazirFamily)
}
