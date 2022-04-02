package dev.yasan.metro.tehran.ui.composable.screen.about.modules.stat

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.yasan.kit.compose.foundation.grid
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.model.tehro.StatComplex
import dev.yasan.metro.tehran.ui.composable.common.teh.TehDivider
import dev.yasan.metro.tehran.ui.composable.common.teh.TehProgress
import dev.yasan.metro.tehran.ui.composable.screen.about.AboutScreen
import dev.yasan.metro.tehran.ui.composable.screen.about.modules.stat.list.StatComplexList
import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * A segment of [AboutScreen] that shows information about the app.
 */
@Composable
fun SegmentStatsComplex(
    statsComplexResource: Resource<List<StatComplex>>?,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {

    Column(
        modifier = Modifier
            .animateContentSize()
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

        when (statsComplexResource) {

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

                val statsComplex = statsComplexResource.data ?: emptyList()

                StatComplexList(
                    stats = statsComplex,
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
