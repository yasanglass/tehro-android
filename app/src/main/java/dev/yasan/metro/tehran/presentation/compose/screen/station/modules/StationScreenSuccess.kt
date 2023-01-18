package dev.yasan.metro.tehran.presentation.compose.screen.station.modules

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Map
import androidx.compose.material.icons.sharp.MultipleStop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.station.Station
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehButton
import dev.yasan.metro.tehran.presentation.compose.preview.provider.station.StationPreviewProvider
import dev.yasan.metro.tehran.presentation.compose.screen.station.modules.accessibility.AccessibilityEmsIndicator
import dev.yasan.metro.tehran.presentation.compose.screen.station.modules.accessibility.AccessibilityIndicator
import dev.yasan.metro.tehran.presentation.navigation.Navigator
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.entity.LaunchSource
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

@Composable
fun StationScreenSuccess(
    station: Station,
    navController: NavController,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    launchSource: LaunchSource,
    forceFarsi: Boolean = false
) {
    val context = LocalContext.current

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
                        .padding(top = if (LocaleHelper.isFarsi) grid(3) else grid(2)),
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
                fontSize = 22.sp
            )
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = grid(2))
            ) {
                AccessibilityEmsIndicator(
                    modifier = Modifier.padding(bottom = grid(2)),
                    emergencyMedicalServices = station.hasEmergencyMedicalServices
                )

                listOf(
                    station.accessibilityLevelBlindness,
                    station.accessibilityLevelWheelchair,
                    station.wc
                ).forEach { accessibility ->

                    accessibility?.let {
                        AccessibilityIndicator(
                            modifier = Modifier.padding(bottom = grid(2)),
                            accessibility = it
                        )
                    }
                }

                if (station.hasLocation) {
                    TehButton(
                        modifier = Modifier.fillMaxWidth(),
                        title = stringResource(R.string.view_on_map),
                        icon = TehroIcons.Map,
                        colorBorder = colorResource(id = R.color.text_title),
                        onClick = {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(
                                    "geo:${station.locationLatitude},${station.locationLongitude}?q=${station.locationLatitude},${station.locationLongitude}(${station.name})"
                                )
                            )

                            try {
                                context.startActivity(intent)
                            } catch (ex: ActivityNotFoundException) {
                                Toast.makeText(
                                    context,
                                    context.getString(R.string.no_app_found_map),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )

                    Spacer(modifier = Modifier.requiredHeight(grid(2)))
                }

                if (launchSource == LaunchSource.SEARCH) {
                    station.line?.let { line ->

                        TehButton(
                            colorBackground = line.color,
                            colorBorder = line.color,
                            modifier = Modifier.fillMaxWidth(),
                            title = line.getFullName(context = context),
                            icon = TehroIcons.MultipleStop,
                            onClick = {
                                Navigator.navigateToLineDetails(
                                    navController = navController,
                                    line = line,
                                    launchSource = launchSource
                                )
                            }
                        )

                        Spacer(modifier = Modifier.requiredHeight(grid(2)))
                    }
                }

                station.intersection?.let { intersection ->

                    intersection.getOppositeLine(stationId = station.id)?.let { line ->

                        TehButton(
                            colorBackground = line.color,
                            colorBorder = line.color,
                            modifier = Modifier.fillMaxWidth(),
                            title = line.getFullName(context = context),
                            icon = TehroIcons.MultipleStop,
                            onClick = {
                                Navigator.navigateToLineDetails(
                                    navController = navController,
                                    line = line,
                                    launchSource = launchSource
                                )
                            }
                        )

                        Spacer(modifier = Modifier.requiredHeight(grid(2)))
                    }
                }
            }
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
    StationScreenSuccess(
        station = station,
        fontFamily = rubikFamily,
        navController = rememberNavController(),
        launchSource = LaunchSource.LINE
    )
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
    StationScreenSuccess(
        station = station,
        fontFamily = vazirFamily,
        forceFarsi = true,
        navController = rememberNavController(),
        launchSource = LaunchSource.LINE
    )
}
