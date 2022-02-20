package dev.yasan.metro.tehran.ui.composable.screen.about

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import dev.yasan.kit.compose.foundation.grid
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.common.teh.TehScreen
import dev.yasan.metro.tehran.ui.composable.screen.about.modules.app.AboutSegmentApp
import dev.yasan.metro.tehran.ui.composable.screen.about.modules.dev.AboutSegmentDev
import dev.yasan.metro.tehran.ui.composable.screen.about.modules.stat.SegmentStats
import dev.yasan.metro.tehran.ui.navigation.NavGraph
import dev.yasan.metro.tehran.ui.navigation.NavRoutes
import dev.yasan.metro.tehran.util.LocaleHelper

/**
 * The about screen. Shows information about the app & the developer(s).
 *
 * @see NavGraph
 * @see NavRoutes.routeAbout
 */
@Composable
fun AboutScreen(
    fontFamily: FontFamily = LocaleHelper.properFontFamily,
    aboutViewModel: AboutViewModel
) {

    val databaseInformation = aboutViewModel.databaseInformation.observeAsState()
    val stats = aboutViewModel.stats.observeAsState()

    TehScreen(
        title = stringResource(id = R.string.about),
        fontFamily = fontFamily
    ) {

        item {
            AboutSegmentApp()
        }

        item {
            Spacer(modifier = Modifier.requiredHeight(grid(2)))
        }

        item {
            AboutSegmentDev()
        }

        item {
            Spacer(modifier = Modifier.requiredHeight(grid(2)))
        }

        item {
            stats.value?.let { statsResource ->
                SegmentStats(
                    statsResource = statsResource,
                    databaseInformation = databaseInformation.value?.data
                )
                Spacer(modifier = Modifier.requiredHeight(grid(2)))
            }
        }

        item {
            Spacer(modifier = Modifier.requiredHeight(grid(8)))
        }

    }

    DisposableEffect(key1 = aboutViewModel) {
        if (databaseInformation.value is Resource.Initial) {
            aboutViewModel.loadDatabaseInformation()
        }
        if (stats.value is Resource.Initial) {
            aboutViewModel.loadStats()
        }
        onDispose {

        }
    }

}
