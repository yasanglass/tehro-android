package dev.yasan.metro.tehran.presentation.compose.screen.about.modules.stat.list

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.stat.Stat
import dev.yasan.metro.tehran.domain.entity.stat.StatComplex
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.toPersianNumbers
import glass.yasan.kit.compose.foundation.grid

/**
 * Shows a list of [Stat]s in a Composable.
 */
@Composable
fun StatComplexList(
    stats: List<StatComplex>,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground))
    ) {
        stats.forEach { stat ->
            if (stat.value != null) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = grid(), horizontal = grid(2)),
                        text = stat.title,
                        color = colorResource(id = R.color.text_desc),
                        fontFamily = fontFamily,
                        textAlign = TextAlign.Start,
                        fontSize = 12.sp
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
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            } else {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = grid(), horizontal = grid(2)),
                    text = stat.title,
                    color = colorResource(id = R.color.text_title),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}
