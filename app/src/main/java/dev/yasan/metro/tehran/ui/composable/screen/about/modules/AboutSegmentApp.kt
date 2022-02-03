package dev.yasan.metro.tehran.ui.composable.screen.about.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Launch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import dev.yasan.kit.library.helper.WebHelper
import dev.yasan.kit.library.ui.theme.rubikFamily
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
import dev.yasan.metro.tehran.ui.composable.common.teh.TehButton
import dev.yasan.metro.tehran.ui.composable.screen.about.AboutScreen
import dev.yasan.metro.tehran.ui.preview.dbinfo.DatabaseInformationPreviewProvider
import dev.yasan.metro.tehran.ui.theme.TehroIcons
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * A segment of [AboutScreen] that shows information about the app.
 */
@Composable
fun AboutSegmentApp(
    databaseInformation: DatabaseInformation?,
    fontFamily: FontFamily = LocaleHelper.properFontFamily
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(grid(2)),
            text = stringResource(R.string.about_app),
            fontFamily = fontFamily,
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_title),
            textAlign = TextAlign.Center
        )

        TehButton(
            title = stringResource(id = R.string.github),
            icon = TehroIcons.Launch,
            onClick = {
                WebHelper.openWebView(context = context, url = AboutLinks.URL_APP_GITHUB)
            },
            fontFamily = fontFamily
        )

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        Divider(modifier = Modifier.background(color = colorResource(id = R.color.divider)))

        databaseInformation?.let { info ->

            Text(
                modifier = Modifier.padding(grid(2)),
                text = stringResource(
                    id = R.string.database_last_modified_on_date,
                    info.getLastModifiedString()
                ),
                fontFamily = fontFamily,
                fontSize = 12.sp,
                color = colorResource(id = R.color.text_desc),
                textAlign = TextAlign.Center
            )

            Divider(modifier = Modifier.background(color = colorResource(id = R.color.divider)))

        }

    }

}

@Preview("About App [en]", group = "light", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About App [en]", group = "dark", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentAppPreviewEn(@PreviewParameter(DatabaseInformationPreviewProvider::class) databaseInformation: DatabaseInformation?) {
    AboutSegmentApp(databaseInformation = databaseInformation, fontFamily = rubikFamily)
}

@Preview("About App [fa]", group = "light", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About App [fa]", group = "dark", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentAppPreviewFa(@PreviewParameter(DatabaseInformationPreviewProvider::class) databaseInformation: DatabaseInformation?) {
    AboutSegmentApp(databaseInformation = databaseInformation, fontFamily = vazirFamily)
}