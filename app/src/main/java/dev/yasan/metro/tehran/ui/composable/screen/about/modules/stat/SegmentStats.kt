package dev.yasan.metro.tehran.ui.composable.screen.about.modules.stat

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import dev.yasan.kit.library.helper.WebHelper
import dev.yasan.kit.library.ui.theme.rubikFamily
import dev.yasan.kit.library.util.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
import dev.yasan.metro.tehran.data.db.entity.Stat
import dev.yasan.metro.tehran.ui.composable.common.teh.TehButton
import dev.yasan.metro.tehran.ui.composable.common.teh.TehDivider
import dev.yasan.metro.tehran.ui.composable.common.teh.TehProgress
import dev.yasan.metro.tehran.ui.composable.screen.about.AboutScreen
import dev.yasan.metro.tehran.ui.preview.dbinfo.DatabaseInformationPreviewProvider
import dev.yasan.metro.tehran.ui.theme.TehroIcons
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * A segment of [AboutScreen] that shows information about the app.
 */
@Composable
fun SegmentStats(
    statsResource: Resource<List<Stat>>,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(grid(2)),
            text = stringResource(R.string.statistics).uppercase(),
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
            }
            else -> {
                TehProgress()
            }
        }
        Spacer(modifier = Modifier.requiredHeight(grid(2)))
        TehDivider()

    }
}
