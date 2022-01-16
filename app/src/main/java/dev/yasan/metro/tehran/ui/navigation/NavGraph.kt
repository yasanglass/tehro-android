package dev.yasan.metro.tehran.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.screen.MainViewModel
import dev.yasan.metro.tehran.ui.composable.screen.about.AboutScreen
import dev.yasan.metro.tehran.ui.composable.screen.home.HomeScreen
import dev.yasan.metro.tehran.ui.composable.screen.home.HomeViewModel
import dev.yasan.metro.tehran.ui.composable.screen.line.LineScreen
import dev.yasan.metro.tehran.ui.composable.screen.line.LineViewModel
import dev.yasan.metro.tehran.ui.composable.screen.map.MapScreen
import dev.yasan.metro.tehran.ui.composable.screen.map.MapViewModel
import dev.yasan.metro.tehran.ui.theme.themePrimary

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

    val navController = rememberAnimatedNavController()
    val systemUiController = rememberSystemUiController()
        .apply { setNavigationBarColor(color = colorResource(id = R.color.layer_background)) }

    val mainViewModel: MainViewModel = hiltViewModel()

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { _, _ ->
            expandIn()
        },
        popEnterTransition = { _, _ ->
            expandIn()
        },
        exitTransition = { _, _ ->
            fadeOut()
        },
        popExitTransition = { _, _ ->
            fadeOut()
        },
    ) {

        composable(route = NavRoutes.routeHome()) {

            systemUiController.setStatusBarColor(color = themePrimary)

            val homeViewModel: HomeViewModel = hiltViewModel(it)

            HomeScreen(
                mainViewModel = mainViewModel,
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

            val line = mainViewModel.getLineById(lineId = lineId)

            systemUiController.setStatusBarColor(color = line?.color ?: Color.DarkGray)

            LineScreen(
                lineViewModel = lineViewModel,
                navController = navController,
                line = line
            )
        }

        composable(route = NavRoutes.routeMap()) {

            systemUiController.setStatusBarColor(color = themePrimary)

            val mapViewModel: MapViewModel = hiltViewModel(it)

            MapScreen(mapViewModel = mapViewModel)
        }

        composable(
            route = NavRoutes.routeAbout(),
        ) {

            AboutScreen()
        }
    }
}
