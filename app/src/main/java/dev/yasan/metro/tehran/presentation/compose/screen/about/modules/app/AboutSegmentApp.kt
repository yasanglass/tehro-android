package dev.yasan.metro.tehran.presentation.compose.screen.about.modules.app

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.sharp.Launch
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import dev.yasan.kit.compose.foundation.grid
import dev.yasan.kit.compose.type.rubikFamily
import dev.yasan.kit.core.WebHelper
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.dbinfo.DatabaseInformation
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.theme.vazirFamily
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehButton
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehDivider
import dev.yasan.metro.tehran.presentation.compose.preview.PreviewDataHolder
import dev.yasan.metro.tehran.presentation.compose.preview.provider.dbinfo.DatabaseInformationPreviewProvider
import dev.yasan.metro.tehran.presentation.compose.screen.about.AboutScreen
import dev.yasan.metro.tehran.presentation.compose.screen.about.modules.AboutLinks
import kotlinx.coroutines.delay

/**
 * A segment of [AboutScreen] that shows information about the app.
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AboutSegmentApp(
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
) {

    val context = LocalContext.current

    val lineColors = PreviewDataHolder.lineColors
    val disabledLineColor: MutableState<Color?> = remember {
        mutableStateOf(lineColors.random())
    }

    fun disableAnotherColor() {
        val enabledColors = ArrayList<Color>().apply {
            addAll(lineColors)
            remove(disabledLineColor.value)
        }
        disabledLineColor.value = enabledColors.random()
    }

    LaunchedEffect(Unit) {
        while (true) {
            disableAnotherColor()
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.layer_foreground)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize()
                    .fillMaxSize()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { disableAnotherColor() }
            ) {
                lineColors.forEach { color ->
                    AnimatedVisibility(color != disabledLineColor.value) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeight(grid(3))
                                .background(color = color)
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.padding(grid(3)),
                text = stringResource(R.string.app_name).uppercase(),
                fontFamily = fontFamily,
                fontSize = if (LocaleHelper.isFarsi) 40.sp else 32.sp,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black,
            )
        }

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
            fontFamily = fontFamily,
        )

        Spacer(modifier = Modifier.requiredHeight(grid(2)))

        TehDivider()

    }
}

@Preview("About App [en]", group = "Light", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About App [en]", group = "Dark", locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentAppPreviewEn(
    @PreviewParameter(DatabaseInformationPreviewProvider::class) databaseInformation: DatabaseInformation?
) {
    AboutSegmentApp(fontFamily = rubikFamily,)
}

@Preview("About App [fa]", group = "Light", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("About App [fa]", group = "Dark", locale = "fa", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AboutSegmentAppPreviewFa(
    @PreviewParameter(DatabaseInformationPreviewProvider::class) databaseInformation: DatabaseInformation?
) {
    AboutSegmentApp(fontFamily = vazirFamily,)
}
