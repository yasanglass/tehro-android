package dev.yasan.metro.tehran.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.presentation.compose.screen.about.AboutScreen
import dev.yasan.metro.tehran.presentation.compose.screen.about.AboutViewModel
import dev.yasan.metro.tehran.presentation.compose.screen.home.HomeScreen
import dev.yasan.metro.tehran.presentation.compose.screen.home.HomeViewModel
import dev.yasan.metro.tehran.presentation.compose.screen.line.LineScreen
import dev.yasan.metro.tehran.presentation.compose.screen.line.LineViewModel
import dev.yasan.metro.tehran.presentation.compose.screen.map.MapScreen
import dev.yasan.metro.tehran.presentation.compose.screen.map.MapViewModel
import dev.yasan.metro.tehran.presentation.compose.screen.search.SearchScreen
import dev.yasan.metro.tehran.presentation.compose.screen.search.SearchViewModel
import dev.yasan.metro.tehran.presentation.compose.screen.station.StationScreen
import dev.yasan.metro.tehran.presentation.compose.screen.station.StationViewModel
import dev.yasan.metro.tehran.presentation.util.entity.LaunchSource

/**
 * The main navigation graph for Tehro.
 *
 * @param startDestination The destination route that the app starts with.
 *
 * @see NavRoutes
 */
@ExperimentalMaterialNavigationApi
@ExperimentalAnimationApi
@Composable
fun NavGraph(
    startDestination: String = NavRoutes.routeHome()
) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberAnimatedNavController(bottomSheetNavigator)
    val systemUiController = rememberSystemUiController()
        .apply { setNavigationBarColor(color = colorResource(id = R.color.layer_background)) }

    ModalBottomSheetLayout(bottomSheetNavigator) {
        AnimatedNavHost(
            navController = navController,
            startDestination = startDestination,
            enterTransition = {
                fadeIn()
            },
            popEnterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            },
            popExitTransition = {
                fadeOut()
            },
        ) {
            composable(route = NavRoutes.routeHome()) {
                systemUiController.setStatusBarColor(color = colorResource(id = R.color.layer_midground))

                val homeViewModel: HomeViewModel = hiltViewModel(it)

                HomeScreen(
                    homeViewModel = homeViewModel,
                    navController = navController
                )
            }

            composable(
                route = NavRoutes.routeLineBase(),
                arguments = listOf(
                    navArgument(NavRoutes.EXTRA_LINE_ID) {
                        type = NavType.IntType
                    },
                )
            ) {
                val lineViewModel: LineViewModel = hiltViewModel(it)

                val lineId =
                    it.arguments?.getInt(NavRoutes.EXTRA_LINE_ID) ?: 0

                LineScreen(
                    lineViewModel = lineViewModel,
                    navController = navController,
                    lineId = lineId
                )
            }

            composable(route = NavRoutes.routeSearch()) {
                systemUiController.setStatusBarColor(color = colorResource(id = R.color.layer_midground))

                val searchViewModel: SearchViewModel = hiltViewModel(it)

                SearchScreen(viewModel = searchViewModel, navController = navController)
            }

            composable(route = NavRoutes.routeMap()) {
                systemUiController.setStatusBarColor(color = colorResource(id = R.color.layer_midground))

                val mapViewModel: MapViewModel = hiltViewModel(it)

                MapScreen(mapViewModel = mapViewModel)
            }

            composable(
                route = NavRoutes.routeAbout(),
            ) {
                val aboutViewModel: AboutViewModel = hiltViewModel(it)

                AboutScreen(aboutViewModel = aboutViewModel)
            }

            bottomSheet(
                route = NavRoutes.routeStationBase(),
                arguments = listOf(
                    navArgument(NavRoutes.EXTRA_STATION_ID) {
                        type = NavType.IntType
                    },
                    navArgument(NavRoutes.EXTRA_LAUNCH_SOURCE) {
                        type = NavType.IntType
                    }
                )
            ) {
                val stationId =
                    it.arguments?.getInt(NavRoutes.EXTRA_STATION_ID) ?: 0
                val launchSource =
                    it.arguments?.getInt(NavRoutes.EXTRA_LAUNCH_SOURCE) ?: LaunchSource.INVALID.ordinal

                val stationViewModel: StationViewModel = hiltViewModel(it)

                StationScreen(
                    stationViewModel = stationViewModel,
                    navController = navController,
                    stationId = stationId,
                    launchSource = LaunchSource.fromInt(launchSource)
                )
            }
        }
    }
}
