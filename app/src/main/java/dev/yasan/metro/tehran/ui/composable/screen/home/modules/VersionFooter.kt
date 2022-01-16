package dev.yasan.metro.tehran.ui.composable.screen.home.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yasan.metro.tehran.BuildConfig
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
import dev.yasan.metro.tehran.ui.composable.common.teh.TehFooter
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.util.PreviewHelper
import dev.yasan.metro.tehran.util.extension.toPersianNumbers

/**
 * A footer meant to show basic information about the application.
 */
@Composable
fun VersionFooter(databaseInformation: DatabaseInformation?) {
    val versionName =
        if (LocaleHelper.isFarsi) BuildConfig.VERSION_NAME.toPersianNumbers() else BuildConfig.VERSION_NAME
    TehFooter(
        text = "${stringResource(id = R.string.app_name)} ${stringResource(id = R.string.version_prefix)}$versionName",
        spacerTop = false,
        spacerBottom = false
    )
}

@Preview(
    name = "Version Footer [en]",
    locale = "en"
)
@Composable
private fun VersionFooterPreviewEn() {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.layer_midground))
            .padding(vertical = grid(2))
    ) {
        VersionFooter(databaseInformation = PreviewHelper.databaseInformation)
    }
}

@Preview(
    name = "Version Footer [fa]",
    locale = "fa"
)
@Composable
private fun VersionFooterPreviewFa() {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.layer_midground))
            .padding(vertical = grid(2))
    ) {
        VersionFooter(databaseInformation = PreviewHelper.databaseInformation)
    }
}
