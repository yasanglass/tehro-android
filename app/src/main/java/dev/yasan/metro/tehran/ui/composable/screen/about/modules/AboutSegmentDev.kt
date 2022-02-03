package dev.yasan.metro.tehran.ui.composable.screen.about.modules

import android.content.res.Configuration
import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.yasan.kit.library.ui.theme.rubikFamily
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.common.yasan.YasanBrandingFooter
import dev.yasan.metro.tehran.ui.theme.grid
import dev.yasan.metro.tehran.ui.theme.vazirFamily
import dev.yasan.metro.tehran.util.LocaleHelper
import dev.yasan.metro.tehran.ui.composable.screen.about.AboutScreen

/**
 * A segment of [AboutScreen] that shows information about the app's developer.
 */
@Composable
fun AboutSegmentDev(fontFamily: FontFamily = LocaleHelper.properFontFamily) {

    Column(
        modifier = Modifier.background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        YasanBrandingFooter(spacerTop = false, spacerBottom = false)

        Text(
            modifier = Modifier.padding(grid(2)),
            text = stringResource(R.string.about_yasan),
            fontFamily = fontFamily,
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_title),
            textAlign = TextAlign.Center
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
            )

            AboutLinkButton(
                icon = AboutIcons.telegramIcon(),
                url = AboutLinks.URL_DEV_TELEGRAM,
                contentDescription = stringResource(
                    id = R.string.telegram_channel
                ),
            )

            AboutLinkButton(
                icon = AboutIcons.mediumIcon(),
                url = AboutLinks.URL_DEV_MEDIUM,
                contentDescription = stringResource(
                    id = R.string.medium
                ),
            )

            AboutLinkButton(
                icon = AboutIcons.discordIcon(),
                url = AboutLinks.URL_DEV_DISCORD,
                contentDescription = stringResource(
                    id = R.string.discord_server
                ),
            )

            AboutLinkButton(
                icon = AboutIcons.instagramIcon(),
                url = AboutLinks.URL_DEV_INSTAGRAM,
                contentDescription = stringResource(
                    id = R.string.instagram
                ),
            )
        }

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        Divider(modifier = Modifier.background(color = colorResource(id = R.color.divider)))

    }

}

@Preview("About Dev [en]", group = "light", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About Dev [en]", group = "dark", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentDevPreviewEn() {
    AboutSegmentDev(fontFamily = rubikFamily)
}

@Preview("About Dev [fa]", group = "light", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About Dev [fa]", group = "dark", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentDevPreviewFa() {
    AboutSegmentDev(fontFamily = vazirFamily)
}