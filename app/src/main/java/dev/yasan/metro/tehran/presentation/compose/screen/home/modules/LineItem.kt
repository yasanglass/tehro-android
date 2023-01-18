package dev.yasan.metro.tehran.presentation.compose.screen.home.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Text
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
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.domain.entity.line.LineType
import dev.yasan.metro.tehran.presentation.compose.preview.provider.line.LineListPreviewProvider
import dev.yasan.metro.tehran.presentation.compose.preview.provider.line.LinePreviewProvider
import dev.yasan.metro.tehran.presentation.navigation.Navigator
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.entity.LaunchSource
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.getTextOnColor
import dev.yasan.metro.tehran.presentation.util.helper.extension.toStringPersian
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * Composable function that shows a single [Line].
 */
@Composable
fun LineItem(
    line: Line,
    modifier: Modifier = Modifier,
    navController: NavController,
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
                .clickable {
                    Navigator.navigateToLineDetails(
                        navController = navController,
                        line = line,
                        launchSource = LaunchSource.LINE
                    )
                }
                .padding(grid(2)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (forceFarsi) line.nameFa else line.name,
                color = color.getTextOnColor(),
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = if (LocaleHelper.isFarsi || forceFarsi) line.id.toStringPersian() else line.id.toString(),
                color = color.getTextOnColor(),
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(
    name = "Lines [en]",
    group = "Lines List",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Lines [en]",
    group = "Lines List",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LinesPreviewEn(@PreviewParameter(LineListPreviewProvider::class) lines: List<Line>) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        lines.forEach {
            LineItem(
                line = it,
                navController = rememberNavController(),
                fontFamily = rubikFamily,
                forceFarsi = false
            )
        }
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Lines [fa]",
    group = "Lines List",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Lines [fa]",
    group = "Lines List",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LinesPreviewFa(@PreviewParameter(LineListPreviewProvider::class) lines: List<Line>) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        lines.forEach {
            LineItem(
                line = it,
                navController = rememberNavController(),
                fontFamily = vazirFamily,
                forceFarsi = true
            )
        }
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Line [en]",
    group = "Single Line",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Line [en]",
    group = "Single Line",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LinePreviewEn(
    @PreviewParameter(LinePreviewProvider::class) line: Line
) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        LineItem(
            line = line,
            navController = rememberNavController(),
            fontFamily = rubikFamily,
            forceFarsi = false
        )
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Line [fa]",
    group = "Single Line",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Line [fa]",
    group = "Single Line",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LinePreviewFa(
    @PreviewParameter(LinePreviewProvider::class) line: Line
) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        LineItem(
            line = line,
            navController = rememberNavController(),
            fontFamily = vazirFamily,
            forceFarsi = true
        )
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}
