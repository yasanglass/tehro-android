package dev.yasan.metro.tehran.presentation.compose.screen.home.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Map
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.theme.dimenDivider
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.getTextOnColor
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

@Composable
fun HomeButton(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    onClick: () -> Unit
) {
    val colorBackground = colorResource(id = R.color.layer_foreground)
    val colorForeground = colorBackground.getTextOnColor()
    Row(
        modifier = modifier
            .padding(horizontal = grid(1.5f))
            .padding(top = grid())
            .fillMaxWidth()
            .background(color = colorBackground)
            .border(width = dimenDivider, color = colorForeground)
            .clickable(onClick = onClick)
            .padding(grid(2)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title.uppercase(),
            color = colorForeground,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.requiredWidth(grid(2)))
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = colorForeground
        )
    }
}

@Preview(
    name = "Map Button [en]",
    group = "Map Button",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Map Button [en]",
    group = "Map Button",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun MapButtonPreviewEn() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        HomeButton(
            title = stringResource(id = R.string.map),
            icon = TehroIcons.Map,
            fontFamily = rubikFamily,
        ) {}
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Map Button [fa]",
    group = "Map Button",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Map Button [fa]",
    group = "Map Button",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun MapButtonPreviewFa() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        HomeButton(
            title = stringResource(id = R.string.map),
            icon = TehroIcons.Map,
            fontFamily = vazirFamily,
        ) {}
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Search Button [en]",
    group = "Search Button",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Search Button [en]",
    group = "Search Button",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun SearchButtonPreviewEn() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        HomeButton(
            title = stringResource(id = R.string.search),
            icon = TehroIcons.Search,
            fontFamily = rubikFamily,
        ) {}
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}

@Preview(
    name = "Search Button [fa]",
    group = "Search Button",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Search Button [fa]",
    group = "Search Button",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun SearchButtonPreviewFa() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.layer_midground))
            .padding(bottom = grid())
    ) {
        Spacer(modifier = Modifier.requiredHeight(grid()))
        HomeButton(
            title = stringResource(id = R.string.search),
            icon = TehroIcons.Search,
            fontFamily = vazirFamily,
        ) {}
        Spacer(modifier = Modifier.requiredHeight(grid()))
    }
}
