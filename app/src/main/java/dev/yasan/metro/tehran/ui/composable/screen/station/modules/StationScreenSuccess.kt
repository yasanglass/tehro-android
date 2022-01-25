package dev.yasan.metro.tehran.ui.composable.screen.station.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.ui.preview.station.StationPreviewProvider
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.rubikFamily
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper

@Composable
fun StationScreenSuccess(
    station: Station,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {

            station.getIcon()?.let {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = grid(2))
                        .padding(top = grid(2)),
                    imageVector = it,
                    contentDescription = null,
                    tint = colorResource(id = R.color.text_title)
                )
            }

        }

        item {

            Text(
                modifier = Modifier.padding(grid(2)),
                text = if (forceFarsi) station.nameFa else station.name,
                fontFamily = fontFamily,
                color = colorResource(id = R.color.text_title),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

        }

    }

}

@Preview(
    "Station Screen (Success)",
    group = "Light",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    "Station Screen (Success)",
    group = "Dark",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StationScreenSuccessPreviewEn(@PreviewParameter(StationPreviewProvider::class) station: Station) {
    StationScreenSuccess(station = station, fontFamily = rubikFamily)
}

@Preview(
    "Station Screen (Success)",
    group = "Light",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    "Station Screen (Success)",
    group = "Dark",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StationScreenSuccessPreviewFa(@PreviewParameter(StationPreviewProvider::class) station: Station) {
    StationScreenSuccess(station = station, fontFamily = vazirFamily, forceFarsi = true)
}