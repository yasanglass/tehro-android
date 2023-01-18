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
import androidx.compose.material.icons.sharp.Cancel
import androidx.compose.material.icons.sharp.CheckCircle
import androidx.compose.material.icons.sharp.MedicalServices
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.theme.dimenDivider
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily
import glass.yasan.para.bool.ParaBoolean

/**
 * Composable function that presents EMS availability of a station.
 */
@Composable
fun AccessibilityEmsIndicator(
    modifier: Modifier = Modifier,
    emergencyMedicalServices: Boolean,
    fontFamily: FontFamily = LocaleHelper.properFontFamily
) {
    val paddingSize = grid(2)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_midground))
            .border(width = dimenDivider, color = colorResource(id = R.color.divider))
    ) {
        val text =
            stringResource(id = if (emergencyMedicalServices) R.string.ems_available else R.string.ems_unavailable)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingSize),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier,
                imageVector = TehroIcons.MedicalServices,
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
            Spacer(modifier = Modifier.requiredWidth(paddingSize))
            Icon(
                modifier = Modifier,
                imageVector = if (emergencyMedicalServices) TehroIcons.CheckCircle else TehroIcons.Cancel,
                contentDescription = null,
                tint = colorResource(id = R.color.text_title)
            )
        }
    }
}

@Preview(
    name = "EMS Indicator [en]",
    group = "Light Mode [en]",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "EMS Indicator [en]",
    group = "Dark Mode [en]",
    locale = "en",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AccessibilityEmsIndicatorPreviewEn(
    @PreviewParameter(ParaBoolean::class) available: Boolean
) {
    AccessibilityEmsIndicator(
        emergencyMedicalServices = available,
        fontFamily = rubikFamily
    )
}

@Preview(
    name = "EMS Indicator [fa]",
    group = "Light Mode [fa]",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "EMS Indicator [fa]",
    group = "Dark Mode [fa]",
    locale = "fa",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun AccessibilityEmsIndicatorPreviewFa(
    @PreviewParameter(ParaBoolean::class) available: Boolean
) {
    AccessibilityEmsIndicator(
        emergencyMedicalServices = available,
        fontFamily = vazirFamily
    )
}
