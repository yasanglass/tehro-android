package dev.yasan.metro.tehran.presentation.compose.common.teh

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Map
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.theme.dimenDivider
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.getTextOnColor
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * Tehro-themed button.
 * All buttons must use this instead of using the generic button composable.
 *
 * @param title The button's title text.
 * @param icon The icon shown on the start of the button.
 */
@Composable
fun TehButton(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    colorBackground: Color = colorResource(id = R.color.text_title),
    colorBorder: Color = colorBackground.getTextOnColor(),
    colorContent: Color = colorBackground.getTextOnColor(),
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    fontSize: TextUnit = 16.sp,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .background(color = colorBackground)
            .clickable {
                onClick()
            }
            .border(width = dimenDivider, color = colorBorder)
            .padding(grid(2)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier,
            imageVector = icon,
            contentDescription = null,
            tint = colorContent,
        )
        Spacer(modifier = Modifier.requiredWidth(grid(0.5f)))
        Text(
            modifier = Modifier,
            text = title.uppercase(),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize,
            color = colorContent,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    name = "Try Again Button [en]",
    group = "Try Again Button",
    locale = "en",
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Try Again Button [en]",
    group = "Try Again Button",
    locale = "en",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehButtonPreviewEn() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(id = R.string.try_again),
            icon = TehroIcons.Refresh,
            onClick = {},
            fontFamily = rubikFamily,
        )
    }
}

@Preview(
    name = "Try Again Button [fa]",
    group = "Try Again Button",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Try Again Button [fa]",
    group = "Try Again Button",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehButtonPreviewFa() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(id = R.string.try_again),
            icon = TehroIcons.Refresh,
            onClick = {},
            fontFamily = vazirFamily,
        )
    }
}

@Preview(
    name = "About Button [en]",
    group = "About Button",
    locale = "en",
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "About Button [en]",
    group = "About Button",
    locale = "en",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehButtonPreviewEn2() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(id = R.string.about),
            icon = TehroIcons.Info,
            onClick = {},
            fontFamily = rubikFamily,
        )
    }
}

@Preview(
    name = "About Button [fa]",
    group = "About Button",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "About Button [fa]",
    group = "About Button",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehButtonPreviewFa2() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(id = R.string.about),
            icon = TehroIcons.Info,
            onClick = {},
            fontFamily = vazirFamily,
        )
    }
}

@Preview(
    name = "About Button [en]",
    group = "About Button",
    locale = "en",
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Map Button [en]",
    group = "Map Button",
    locale = "en",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehButtonPreviewEn3() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(R.string.view_on_map),
            icon = TehroIcons.Map,
            onClick = {},
            fontFamily = rubikFamily,
        )
    }
}

@Preview(
    name = "Map Button [fa]",
    group = "Map Button",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Map Button [fa]",
    group = "Map Button",
    locale = "fa",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun TehButtonPreviewFa3() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehButton(
            title = stringResource(R.string.view_on_map),
            icon = TehroIcons.Map,
            onClick = {},
            fontFamily = vazirFamily,
        )
    }
}
