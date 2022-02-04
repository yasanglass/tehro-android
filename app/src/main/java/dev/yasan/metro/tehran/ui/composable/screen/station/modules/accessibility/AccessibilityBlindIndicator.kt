package dev.yasan.metro.tehran.ui.composable.screen.station.modules.accessibility

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import dev.yasan.kit.library.ui.theme.rubikFamily
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.AccessibilityBlind
import dev.yasan.metro.tehran.data.db.entity.AccessibilityWheelchair
import dev.yasan.metro.tehran.ui.preview.station.accessibility.StationAccessibilityBlindPreviewProvider
import dev.yasan.metro.tehran.ui.preview.station.accessibility.StationAccessibilityWheelchairPreviewProvider
import dev.yasan.metro.tehran.ui.theme.TehroIcons
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper

@Composable
fun AccessibilityBlindIndicator(
    accessibilityBlind: AccessibilityBlind,
    fontFamily: FontFamily = LocaleHelper.properFontFamily
) {

    val paddingSize = grid(2)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_midground))
    ) {

        val text = stringResource(id = accessibilityBlind.stringResourceId)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingSize),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier,
                imageVector = TehroIcons.VisibilityOff,
                contentDescription = null,
                tint = colorResource(id = R.color.text_title)
            )
            Spacer(modifier = Modifier.requiredWidth(paddingSize))
            Text(
                text = text,
                modifier = Modifier.weight(1f),
                fontFamily = fontFamily,
                color = colorResource(id = R.color.text_title)
            )
            if (accessibilityBlind == AccessibilityBlind.NONE) {
                Spacer(modifier = Modifier.requiredWidth(paddingSize))
                Icon(
                    modifier = Modifier,
                    imageVector = TehroIcons.Cancel,
                    contentDescription = null,
                    tint = colorResource(id = R.color.text_title)
                )
            } else if (accessibilityBlind == AccessibilityBlind.FULL) {
                Spacer(modifier = Modifier.requiredWidth(paddingSize))
                Icon(
                    modifier = Modifier,
                    imageVector = TehroIcons.CheckCircle,
                    contentDescription = null,
                    tint = colorResource(id = R.color.text_title)
                )
            }
        }

    }

}

@Preview(
    name = "Blind Indicator [en]",
    group = "Light Mode [en]",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Blind Indicator [en]",
    group = "Dark Mode [en]",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AccessibilityBlindIndicatorPreviewEn(
    @PreviewParameter(StationAccessibilityBlindPreviewProvider::class) accessibilityBlind: AccessibilityBlind
) {
    AccessibilityBlindIndicator(
        accessibilityBlind = accessibilityBlind,
        fontFamily = rubikFamily
    )
}

@Preview(
    name = "Blind Indicator [fa]",
    group = "Light Mode [fa]",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Blind Indicator [fa]",
    group = "Dark Mode [fa]",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AccessibilityBlindIndicatorPreviewFa(
    @PreviewParameter(StationAccessibilityBlindPreviewProvider::class) accessibilityBlind: AccessibilityBlind
) {
    AccessibilityBlindIndicator(
        accessibilityBlind = accessibilityBlind,
        fontFamily = vazirFamily
    )
}