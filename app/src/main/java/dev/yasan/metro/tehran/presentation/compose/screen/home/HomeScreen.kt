package dev.yasan.metro.tehran.presentation.compose.screen.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Map
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehButton
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehError
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehProgress
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehScreen
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehSegmentTitle
import dev.yasan.metro.tehran.presentation.compose.screen.home.modules.AppVersionFooter
import dev.yasan.metro.tehran.presentation.compose.screen.home.modules.HomeButton
import dev.yasan.metro.tehran.presentation.compose.screen.home.modules.LineItem
import dev.yasan.metro.tehran.presentation.navigation.NavGraph
import dev.yasan.metro.tehran.presentation.navigation.NavRoutes
import dev.yasan.metro.tehran.presentation.navigation.Navigator
import dev.yasan.metro.tehran.presentation.theme.TehroIcons
import dev.yasan.metro.tehran.presentation.util.entity.Action
import glass.yasan.kit.compose.components.YasanBrandingFooter
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.core.Resource

/**
 * The Main/home screen of Tehro. This is the first navigation route that the users see.
 *
 * @see NavGraph
 * @see NavRoutes.routeHome
 */
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    val lines = homeViewModel.lines.observeAsState(initial = Resource.Initial())

    LaunchedEffect(key1 = lines.value) {
        if (lines.value is Resource.Initial) {
            homeViewModel.loadLines()
        }
    }

    TehScreen(
        title = stringResource(id = R.string.app_name),
        actions = listOf(
            Action(
                icon = TehroIcons.Search,
                onClick = {
                    Navigator.navigateToSearch(navController = navController)
                },
                text = stringResource(id = R.string.search)
            )
        )
    ) {
        when (lines.value) {
            is Resource.Error -> {
                item {
                    TehError {
                        homeViewModel.loadLines()
                    }
                }
            }
            is Resource.Success -> {
                val list = lines.value.data ?: ArrayList()

                item {
                    Spacer(modifier = Modifier.requiredHeight(grid()))
                }

                item {
                    HomeButton(title = stringResource(id = R.string.map), icon = TehroIcons.Map) {
                        Navigator.navigateToMap(navController = navController)
                    }
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
