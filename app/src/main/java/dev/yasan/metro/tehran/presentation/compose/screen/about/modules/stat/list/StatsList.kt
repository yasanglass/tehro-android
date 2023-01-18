package dev.yasan.metro.tehran.presentation.compose.screen.about.modules.stat.list

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.stat.Stat
import dev.yasan.metro.tehran.presentation.compose.preview.provider.stat.StatListPreviewProvider
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.toPersianNumbers
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * Shows a list of [Stat]s in a Composable.
 */
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
            Row(verticalAlignment = Alignment.CenterVertically) {
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
                    modifier = Modifier.padding(vertical = grid(), horizontal = grid(2)),
                    text =
                    if (LocaleHelper.isFarsi || forceFarsi) {
                        text.toPersianNumbers()
                    } else {
                        text
                    },
                    color = colorResource(id = R.color.text_title),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Bold
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
