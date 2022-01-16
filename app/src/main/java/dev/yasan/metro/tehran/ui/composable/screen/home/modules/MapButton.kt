package dev.yasan.metro.tehran.ui.composable.screen.home.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Map
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.screen.map.MapScreen
import dev.yasan.metro.tehran.ui.navigation.NavRoutes
import dev.yasan.metro.tehran.ui.theme.*
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.extension.getTextOnColor

/**
 * A simple button that navigated the user to [MapScreen].
 */
@Composable
fun MapButton(
    modifier: Modifier = Modifier,
    navController: NavController,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
) {
    val colorBackground = colorResource(id = R.color.layer_foreground)
    val colorForeground = colorBackground.getTextOnColor()
    Row(
        modifier = modifier
            .padding(horizontal = grid(1.5f))
            .padding(top = grid())
            .fillMaxWidth()
            .background(color = colorBackground)
            .border(width = dimenDivider, color = colorResource(id = R.color.divider))
            .clickable {
                navController.navigate(NavRoutes.routeMap())
            }
            .padding(grid(2)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.map).uppercase(),
            color = colorForeground,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.requiredWidth(grid(2)))
        Icon(
            imageVector = TehroIcons.Map,
            contentDescription = stringResource(id = R.string.map),
            tint = colorForeground
        )
    }
}

@Preview(
    name = "Map Button [en]",
    group = "Map Button",
    locale = "en"
)
@Composable
private fun MapButtonPreviewEn() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        MapButton(navController = rememberNavController(), fontFamily = rubikFamily)
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Map Button [fa]",
    group = "Map Button",
    locale = "fa"
)
@Composable
private fun MapButtonPreviewFa() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        MapButton(navController = rememberNavController(), fontFamily = vazirFamily)
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Map Button [en]",
    group = "Map Button",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun MapButtonPreviewEnDark() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        MapButton(navController = rememberNavController(), fontFamily = rubikFamily)
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Map Button [fa]",
    group = "Map Button",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun MapButtonPreviewFaDark() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        MapButton(navController = rememberNavController(), fontFamily = vazirFamily)
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}
