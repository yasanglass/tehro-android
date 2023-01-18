package dev.yasan.metro.tehran.presentation.compose.screen.about.modules.stat

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Launch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.dbinfo.DatabaseInformation
import dev.yasan.metro.tehran.domain.entity.stat.Stat
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehButton
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehDivider
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehProgress
import dev.yasan.metro.tehran.presentation.compose.screen.about.AboutScreen
import dev.yasan.metro.tehran.presentation.compose.screen.about.modules.AboutLinks
import dev.yasan.metro.tehran.presentation.compose.screen.about.modules.stat.list.StatsList
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.core.Resource
import glass.yasan.kit.core.WebHelper

/**
 * A segment of [AboutScreen] that shows information about the app.
 */
@Composable
fun SegmentStats(
    statsResource: Resource<List<Stat>>?,
    databaseInformation: DatabaseInformation?,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(grid(2)),
            text = stringResource(R.string.database).uppercase(),
            fontFamily = fontFamily,
            fontSize = 18.sp,
            color = colorResource(id = R.color.text_title),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Black
        )

        when (statsResource) {
            is Resource.Error -> {
                Text(
                    modifier = Modifier.padding(grid(2)),
                    text = stringResource(R.string.failed_to_load_data),
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_desc),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic
                )
            }
            is Resource.Success -> {
                val stats = statsResource.data ?: emptyList()

                StatsList(
                    stats = stats,
                    fontFamily = fontFamily,
                    forceFarsi = forceFarsi
                )

                TehButton(
                    modifier = Modifier.padding(vertical = grid(2)),
                    title = stringResource(id = R.string.github),
                    icon = TehroIcons.Launch,
                    onClick = {
                        WebHelper.openWebView(
                            context = context,
                            url = AboutLinks.URL_DATABASE_GITHUB
                        )
                    },
                    fontFamily = fontFamily,
                )

                databaseInformation?.let { info ->

                    Spacer(modifier = Modifier.requiredHeight(grid()))

                    TehDivider()

                    Text(
                        modifier = Modifier
                            .padding(top = grid(2))
                            .padding(horizontal = grid(2)),
                        text = stringResource(
                            id = R.string.database_last_modified_on_date,
                            info.getLastModifiedString(forceFarsi = forceFarsi)
                        ),
                        fontFamily = fontFamily,
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.text_desc),
                        textAlign = TextAlign.Center
                    )
                }
            }
            else -> {
                TehProgress()
            }
        }

        Spacer(modifier = Modifier.requiredHeight(grid(2)))
        TehDivider()
    }
}
