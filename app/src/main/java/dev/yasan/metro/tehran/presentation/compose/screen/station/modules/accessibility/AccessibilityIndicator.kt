package dev.yasan.metro.tehran.presentation.compose.screen.station.modules.accessibility

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Accessible
import androidx.compose.material.icons.sharp.Cancel
import androidx.compose.material.icons.sharp.CheckCircle
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.VisibilityOff
import androidx.compose.material.icons.sharp.Wc
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevel
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.domain.entity.accessibility.WcAvailabilityLevel
import dev.yasan.metro.tehran.presentation.compose.preview.provider.station.accessibility.StationAccessibilityPreviewProvider
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.theme.dimenDivider
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * Composable function that presents a level-based [AccessibilityLevel] object.
 */
@Composable
fun AccessibilityIndicator(
    modifier: Modifier = Modifier,
    accessibility: AccessibilityLevel,
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    forceFarsi: Boolean = false
) {
    val paddingSize = grid(2)

    val icon = when (accessibility) {
        is AccessibilityLevelWheelchair -> TehroIcons.Accessible
        is AccessibilityLevelBlindness -> TehroIcons.VisibilityOff
        is WcAvailabilityLevel -> TehroIcons.Wc
        else -> TehroIcons.Info
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_midground))
            .border(width = dimenDivider, color = colorResource(id = R.color.divider))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingSize),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier,
                imageVector = icon,
                contentDescription = null,
                tint = colorResource(id = R.color.text_title)
            )
            Spacer(modifier = Modifier.requiredWidth(paddingSize))
            Text(
                text = accessibility.description(forceFarsi = forceFarsi),
                modifier = Modifier.weight(1f),
                fontFamily = fontFamily,
                color = colorResource(id = R.color.text_title)
            )

            val type = accessibility.getType()

            if (type == AccessibilityLevel.Type.MIN) {
                Spacer(modifier = Modifier.requiredWidth(paddingSize))
                Icon(
                    modifier = Modifier,
                    imageVector = TehroIcons.Cancel,
                    contentDescription = null,
                    tint = colorResource(id = R.color.text_title)
                )
            } else if (type == AccessibilityLevel.Type.MAX) {
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
private fun AccessibilityIndicatorPreviewEn(
    @PreviewParameter(StationAccessibilityPreviewProvider::class) accessibility: AccessibilityLevel
) {
    AccessibilityIndicator(
        accessibility = accessibility,
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
private fun AccessibilityIndicatorPreviewFa(
    @PreviewParameter(StationAccessibilityPreviewProvider::class) accessibility: AccessibilityLevel
) {
    AccessibilityIndicator(
        accessibility = accessibility,
        fontFamily = vazirFamily,
        forceFarsi = true
    )
}
