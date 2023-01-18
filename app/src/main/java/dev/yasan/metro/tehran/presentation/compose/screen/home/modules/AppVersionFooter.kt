package dev.yasan.metro.tehran.presentation.compose.screen.home.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.BuildConfig
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehFooter
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.FlavorHelper
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.util.helper.extension.toPersianNumbers
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.compose.type.rubikFamily

/**
 * A footer meant to show basic information about the application.
 */
@Composable
fun AppVersionFooter(
    fontFamily: FontFamily = LocaleHelper.properFontFamily
) {
    val versionName =
        if (LocaleHelper.isFarsi) BuildConfig.VERSION_NAME.toPersianNumbers() else BuildConfig.VERSION_NAME
    val flavorName = FlavorHelper.getFlavorName(context = LocalContext.current)
    TehFooter(
        text = "${stringResource(id = R.string.app_name)} ${stringResource(id = R.string.version_prefix)}$versionName   ·   $flavorName",
        spacerTop = false,
        spacerBottom = false,
        fontFamily = fontFamily
    )
}

@Preview(
    name = "App Version Footer [en]",
    locale = "en"
)
@Composable
private fun AppVersionFooterPreviewEn() {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.layer_midground))
            .padding(vertical = grid(2))
    ) {
        AppVersionFooter(fontFamily = rubikFamily)
    }
}

@Preview(
    name = "App Version Footer [fa]",
    locale = "fa"
)
@Composable
private fun AppVersionFooterPreviewFa() {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.layer_midground))
            .padding(vertical = grid(2))
    ) {
        AppVersionFooter(fontFamily = vazirFamily)
    }
}
