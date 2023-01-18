package dev.yasan.metro.tehran.presentation.compose.screen.about

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import dev.yasan.metro.tehran.BuildConfig
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehFooter
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehScreen
import dev.yasan.metro.tehran.presentation.compose.screen.about.modules.app.AboutSegmentApp
import dev.yasan.metro.tehran.presentation.compose.screen.about.modules.dev.AboutSegmentDev
import dev.yasan.metro.tehran.presentation.compose.screen.about.modules.stat.SegmentStats
import dev.yasan.metro.tehran.presentation.compose.screen.about.modules.stat.SegmentStatsComplex
import dev.yasan.metro.tehran.presentation.navigation.NavGraph
import dev.yasan.metro.tehran.presentation.navigation.NavRoutes
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.core.Resource

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
    val databaseInformation = aboutViewModel.databaseInformation.observeAsState(initial = Resource.Initial())
    val stats = aboutViewModel.stats.observeAsState(initial = Resource.Initial())
    val statsComplex = aboutViewModel.statsComplex.observeAsState(initial = Resource.Initial())

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
            SegmentStats(
                statsResource = stats.value,
                databaseInformation = databaseInformation.value.data
            )
            Spacer(modifier = Modifier.requiredHeight(grid(2)))
        }

        item {
            Spacer(modifier = Modifier.requiredHeight(grid(2)))
        }

        item {
            SegmentStatsComplex(statsComplexResource = statsComplex.value)
            Spacer(modifier = Modifier.requiredHeight(grid(2)))
        }

        item {
            TehFooter(
                text = "${BuildConfig.VERSION_NAME} - ${BuildConfig.VERSION_CODE} - ${BuildConfig.FLAVOR} - ${BuildConfig.BUILD_TYPE}"
            )
        }

        item {
            Spacer(modifier = Modifier.requiredHeight(grid(2)))
        }
    }

    DisposableEffect(key1 = aboutViewModel) {
        if (databaseInformation.value is Resource.Initial) {
            aboutViewModel.loadDatabaseInformation()
        }
        if (stats.value is Resource.Initial) {
            aboutViewModel.loadBasicStats()
        }
        if (statsComplex.value is Resource.Initial) {
            aboutViewModel.loadComplexStats()
        }
        onDispose {
        }
    }
}
