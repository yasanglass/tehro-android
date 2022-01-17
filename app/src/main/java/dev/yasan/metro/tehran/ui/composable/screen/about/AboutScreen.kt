package dev.yasan.metro.tehran.ui.composable.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import dev.yasan.helper.library.WebHelper
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
import dev.yasan.metro.tehran.ui.composable.common.teh.TehButton
import dev.yasan.metro.tehran.ui.composable.common.teh.TehScreen
import dev.yasan.metro.tehran.ui.composable.common.yasan.YasanBrandingFooter
import dev.yasan.metro.tehran.ui.navigation.NavGraph
import dev.yasan.metro.tehran.ui.navigation.NavRoutes
import dev.yasan.metro.tehran.ui.preview.dbinfo.DatabaseInformationPreviewProvider
import dev.yasan.metro.tehran.ui.theme.TehroIcons
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * The about screen.
 *
 * @see NavGraph
 * @see NavRoutes.routeAbout
 */
@Composable
fun AboutScreen(
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    aboutViewModel: AboutViewModel
) {

    val context = LocalContext.current

    val databaseInformation = aboutViewModel.databaseInformation.observeAsState()

    TehScreen(
        title = stringResource(id = R.string.about),
        fontFamily = fontFamily
    ) {

        item {

            AboutSegmentApp(databaseInformation = databaseInformation.value?.data)

        }

        item {
            Spacer(modifier = Modifier.requiredHeight(grid(2)))
        }

        item {

            AboutSegmentDev()

        }
    }
}

@Preview("About App")
@Composable
/**
 * A segment on [AboutScreen] that shows information about the app.
 */
private fun AboutSegmentApp(
    @PreviewParameter(DatabaseInformationPreviewProvider::class) databaseInformation: DatabaseInformation?,
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
            color = colorResource(id = R.color.text_title)
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
                fontSize = 16.sp,
                color = colorResource(id = R.color.text_desc)
            )

            Divider(modifier = Modifier.background(color = colorResource(id = R.color.divider)))

        }

    }

}

@Preview("About Dev")
@Composable
private fun AboutSegmentDev(fontFamily: FontFamily = LocaleHelper.properFontFamily) {

    Column(
        modifier = Modifier.background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        YasanBrandingFooter(spacerTop = false, spacerBottom = false, ignorePride = true)

        Text(
            modifier = Modifier.padding(grid(2)),
            text = stringResource(R.string.about_yasan),
            fontFamily = fontFamily,
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_title)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AboutLinkButton(
                icon = AboutIcons.twitterIcon(),
                url = if (LocaleHelper.isFarsi) AboutLinks.URL_DEV_TWITTER_FA else AboutLinks.URL_DEV_TWITTER_EN,
                contentDescription = stringResource(
                    id = R.string.twitter
                ),
                linkTitle = "dev.twitter"
            )

            AboutLinkButton(
                icon = AboutIcons.telegramIcon(),
                url = AboutLinks.URL_DEV_TELEGRAM,
                contentDescription = stringResource(
                    id = R.string.telegram_channel
                ),
                linkTitle = "dev.telegram"
            )

            AboutLinkButton(
                icon = AboutIcons.mediumIcon(),
                url = AboutLinks.URL_DEV_MEDIUM,
                contentDescription = stringResource(
                    id = R.string.medium
                ),
                linkTitle = "dev.medium"
            )

            AboutLinkButton(
                icon = AboutIcons.discordIcon(),
                url = AboutLinks.URL_DEV_DISCORD,
                contentDescription = stringResource(
                    id = R.string.discord_server
                ),
                linkTitle = "dev.discord"
            )

            AboutLinkButton(
                icon = AboutIcons.instagramIcon(),
                url = AboutLinks.URL_DEV_INSTAGRAM,
                contentDescription = stringResource(
                    id = R.string.instagram
                ),
                linkTitle = "dev.instagram"
            )
        }

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        Divider(modifier = Modifier.background(color = colorResource(id = R.color.divider)))

    }

}