package dev.yasan.metro.tehran.ui.composable.screen.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.sharp.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.yasan.kit.compose.foundation.grid
import dev.yasan.kit.compose.parts.branding.YasanBrandingFooter
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.common.teh.*
import dev.yasan.metro.tehran.ui.composable.screen.MainViewModel
import dev.yasan.metro.tehran.ui.composable.screen.home.modules.AppVersionFooter
import dev.yasan.metro.tehran.ui.composable.screen.home.modules.LineItem
import dev.yasan.metro.tehran.ui.composable.screen.home.modules.MapButton
import dev.yasan.metro.tehran.ui.navigation.NavGraph
import dev.yasan.metro.tehran.ui.navigation.NavRoutes
import dev.yasan.metro.tehran.ui.theme.TehroIcons

/**
 * The Main/home screen of Tehro. This is the first navigation route that the users see.
 *
 * @see NavGraph
 * @see NavRoutes.routeHome
 */
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    navController: NavController
) {

    val lines = mainViewModel.lines.observeAsState()

    if (lines.value is Resource.Initial) {
        mainViewModel.loadLines()
    }

    TehScreen(title = stringResource(id = R.string.app_name)) {

        when (lines.value) {
            is Resource.Error -> {
                item {
                    TehError {
                        mainViewModel.loadLines()
                    }
                }
            }
            is Resource.Success -> {

                val list = lines.value?.data ?: ArrayList()

                item {
                    Spacer(modifier = Modifier.requiredHeight(grid()))
                }

                item {
                    MapButton(navController = navController)
                }

                item {
                    TehSegmentTitle(
                        title = stringResource(id = R.string.lines),
                        paddingTop = grid(3)
                    )
                }

                items(items = list, key = { it.id }) { line ->
                    LineItem(line = line, navController = navController)
                }

                item {
                    TehButton(
                        modifier = Modifier.padding(vertical = grid(4)),
                        title = stringResource(R.string.about),
                        icon = TehroIcons.Info,
                        onClick = {
                            navController.navigate(NavRoutes.routeAbout())
                        }
                    )
                }

                item {
                    AppVersionFooter()
                }

                item {
                    YasanBrandingFooter(spacerTop = 0.dp)
                }
            }
            else -> {
                item {
                    TehProgress()
                }
            }
        }
    }
}
