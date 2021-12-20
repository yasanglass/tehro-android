package dev.yasan.metro.tehran.ui.composable.screen.home.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.db.entity.LineType
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.rubikFamily
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.getTextOnColor

@Composable
fun LineItem(
    line: Line,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {
    if (line.type == LineType.METRO_LINE) {
        val color = line.color
        Row(
            modifier = modifier
                .padding(horizontal = grid(1.5f))
                .padding(top = grid())
                .fillMaxWidth()
                .background(color = color)
                .padding(grid(2))
        ) {
            Text(
                text = if (forceFarsi) line.nameFa else line.name,
                color = color.getTextOnColor(),
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(name = "Line (En)", locale = "en")
@Composable
private fun LinePreviewEn() {
    val line = Line(
        id = 1,
        nameFa = "یک",
        nameEn = "One",
        colorHex = "C53642",
        typeInt = LineType.METRO_LINE.ordinal
    )
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        LineItem(line = line, fontFamily = rubikFamily, forceFarsi = false)
    }
}

@Preview(name = "Line (Fa)", locale = "fa")
@Composable
private fun LinePreviewFa() {
    val line = Line(
        id = 1,
        nameFa = "یک",
        nameEn = "One",
        colorHex = "C53642",
        typeInt = LineType.METRO_LINE.ordinal
    )
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        LineItem(line = line, fontFamily = vazirFamily, forceFarsi = true)
    }
}