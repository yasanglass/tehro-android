package dev.yasan.metro.tehran.presentation.compose.common.teh

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.toPersianNumbers
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * Tehro-themed footer. Simple footer to show a text on the bottom of a screen.
 *
 * @param text The text shown on the footer.
 * @param spacerTop If the top spacer should be shown.
 * @param spacerBottom If the top bottom should be shown.
 */
@Composable
fun TehFooter(
    modifier: Modifier = Modifier,
    text: String,
    spacerTop: Boolean = true,
    spacerBottom: Boolean = true,
    fontFamily: FontFamily = LocaleHelper.properFontFamily
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (spacerTop) {
            Spacer(
                modifier = Modifier
                    .requiredHeight(grid(8))
                    .testTag("spacer")
            )
        }

        Text(
            text = text,
            color = colorResource(id = R.color.text_desc),
            fontFamily = fontFamily
        )

        if (spacerBottom) {
            Spacer(
                modifier = Modifier
                    .requiredHeight(grid(8))
                    .testTag("spacer")
            )
        }
    }
}

@Preview(name = "Footer [en]", group = "Footer", locale = "en")
@Composable
private fun TehFooterPreviewEn() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehFooter(
            text = stringResource(R.string.n_lines, 9),
            fontFamily = rubikFamily
        )
    }
}

@Preview(name = "Footer [fa]", group = "Footer", locale = "fa")
@Composable
private fun TehFooterPreviewFa() {
    Surface(color = colorResource(id = R.color.layer_midground)) {
        TehFooter(
            text = stringResource(R.string.n_lines, 9).toPersianNumbers(),
            fontFamily = vazirFamily
        )
    }
}
