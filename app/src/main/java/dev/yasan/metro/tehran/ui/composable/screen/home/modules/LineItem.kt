package dev.yasan.metro.tehran.ui.composable.screen.home.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import dev.yasan.metro.tehran.util.PreviewHelper
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

@Preview(name = "Lines (En)", locale = "en")
@Composable
private fun LinesPreviewEn() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        PreviewHelper.lines.forEach {
            LineItem(line = it, fontFamily = rubikFamily, forceFarsi = false)
        }
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(name = "Lines (Fa)", locale = "fa")
@Composable
private fun LinesPreviewFa() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        PreviewHelper.lines.forEach {
            LineItem(line = it, fontFamily = vazirFamily, forceFarsi = true)
        }
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(name = "Line (En)", locale = "en")
@Composable
private fun LinePreviewEn() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        LineItem(line = PreviewHelper.lines.random(), fontFamily = rubikFamily, forceFarsi = false)
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(name = "Line (Fa)", locale = "fa")
@Composable
private fun LinePreviewFa() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        LineItem(line = PreviewHelper.lines.random(), fontFamily = vazirFamily, forceFarsi = true)
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}
