package dev.yasan.metro.tehran.ui.composable.screen.line.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.MultipleStop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.ui.navigation.NavRoutes
import dev.yasan.metro.tehran.ui.preview.station.StationListPreviewProvider
import dev.yasan.metro.tehran.ui.preview.station.StationPreviewProvider
import dev.yasan.metro.tehran.ui.theme.*
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.extension.getTextOnColor

/**
 * Composable function that shows a single [Station].
 */
@Composable
fun StationItem(
    station: Station,
    navController: NavController,
    stationPosition: Station.StationPosition = Station.StationPosition.MIDDLE,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {
    val hasInterchange = station.interchange != null
    val oppositeLineColor = station.interchange?.getOppositeLine(stationId = station.id)?.color
    val colorBackground = oppositeLineColor ?: colorResource(id = R.color.layer_foreground)
    val colorBorder = oppositeLineColor ?: colorResource(id = R.color.divider)

    val colorForeground =
        if (hasInterchange) colorBackground.getTextOnColor()
        else colorResource(id = R.color.text_title)

    Row(
        modifier = Modifier
            .padding(horizontal = grid(1.5f))
            .padding(top = grid())
            .fillMaxWidth()
            .background(color = colorBackground)
            .border(width = dimenDivider, color = colorBorder)
            .clickable(enabled = hasInterchange) {
                if (hasInterchange) {
                    station.interchange
                        ?.getOppositeLine(station.id)
                        ?.let { line ->
                            navController.navigate(NavRoutes.routeLine(line = line))
                        }
                }
            }
            .padding(horizontal = grid(2))
            .padding(vertical = grid(1.25f)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        station.getIcon()?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = colorForeground
            )
            Spacer(modifier = Modifier.requiredWidth(grid(2)))
        }

        Text(
            modifier = Modifier.weight(1f),
            text = if (forceFarsi) station.nameFa else station.name,
            color = colorForeground,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

        if (hasInterchange) {
            Spacer(modifier = Modifier.requiredWidth(grid(2)))
            Icon(
                imageVector = TehroIcons.MultipleStop,
                contentDescription = null,
                tint = colorForeground
            )
        }
    }
}

// FIXME: 2021-12-26 fix previews not showing interchanges

@Preview(
    name = "Station [fa]",
    group = "Single Station",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Station [fa]",
    group = "Station",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StationItemPreviewFa(@PreviewParameter(StationPreviewProvider::class) station: Station) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid(0.5f)))
        StationItem(
            station = station,
            navController = rememberNavController(),
            fontFamily = vazirFamily,
            forceFarsi = true
        )
        Spacer(modifier = Modifier.requiredHeight(grid(0.5f)))
    }
}

@Preview(
    name = "Station [en]",
    group = "Single Station",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Station [en]",
    group = "Station",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StationItemPreviewEn(@PreviewParameter(StationPreviewProvider::class) station: Station) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid(0.5f)))
        StationItem(
            station = station,
            navController = rememberNavController(),
            fontFamily = rubikFamily,
            forceFarsi = false
        )
        Spacer(modifier = Modifier.requiredHeight(grid(0.5f)))
    }
}

@Preview(
    name = "Station List [en]",
    group = "Station List",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Station List [en]",
    group = "Station List",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StationItemsPreviewEn(@PreviewParameter(StationListPreviewProvider::class) stations: List<Station>) {
    val navController = rememberNavController()
    Column(modifier = Modifier.background(color = colorResource(id = R.color.layer_midground))) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        stations.forEach { station ->
            StationItem(
                station = station,
                navController = navController,
                fontFamily = rubikFamily,
                forceFarsi = false
            )
        }
        Spacer(modifier = Modifier.requiredHeight(grid(2)))
    }
}

@Preview(
    name = "Station List [fa]",
    group = "Station List",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Station List [fa]",
    group = "Station List",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StationItemsPreviewFa(@PreviewParameter(StationListPreviewProvider::class) stations: List<Station>) {
    val navController = rememberNavController()
    Column(modifier = Modifier.background(color = colorResource(id = R.color.layer_midground))) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        stations.forEach { station ->
            StationItem(
                station = station,
                navController = navController,
                fontFamily = vazirFamily,
                forceFarsi = true
            )
        }
        Spacer(modifier = Modifier.requiredHeight(grid(2)))
    }
}
