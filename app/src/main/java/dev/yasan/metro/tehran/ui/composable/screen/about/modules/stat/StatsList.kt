package dev.yasan.metro.tehran.ui.composable.screen.about.modules.stat

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import dev.yasan.kit.library.ui.theme.rubikFamily
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Stat
import dev.yasan.metro.tehran.ui.composable.common.teh.TehDivider
import dev.yasan.metro.tehran.ui.preview.stat.StatListPreviewProvider
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.extension.toPersianNumbers

@Composable
fun StatsList(
    stats: List<Stat>,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground))
    ) {
        stats.forEach { stat ->
            Row {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = grid(), horizontal = grid(2)),
                    text = stringResource(id = stat.titleStringResourceId),
                    color = colorResource(id = R.color.text_desc),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Start
                )
                val text = stat.value.toString()
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(grid(2)),
                    text =
                    if (LocaleHelper.isFarsi || forceFarsi)
                        text.toPersianNumbers()
                    else
                        text,
                    color = colorResource(id = R.color.text_title),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

@Preview("Stats List [en]", group = "light", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("Stats List [en]", group = "dark", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentAppPreviewEn(
    @PreviewParameter(StatListPreviewProvider::class) stats: List<Stat>
) {
    StatsList(stats = stats, fontFamily = rubikFamily)
}

@Preview(
    "AStats List [fa]",
    group = "light",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview("Stats List [fa]", group = "dark", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentAppPreviewFa(
    @PreviewParameter(StatListPreviewProvider::class) stats: List<Stat>
) {
    StatsList(stats = stats, fontFamily = vazirFamily, forceFarsi = true)
}