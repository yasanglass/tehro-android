package dev.yasan.metro.tehran.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dev.yasan.metro.tehran.ui.composable.screen.home.HomeScreen
import dev.yasan.metro.tehran.ui.composable.screen.home.HomeViewModel

@ExperimentalAnimationApi
@Composable
fun NavGraph(
    startDestination: String = NavDestinations.ROUTE_HOME
) {

    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { _, _ ->
            fadeIn()
        },
        popEnterTransition = { _, _ ->
            fadeIn()
        },
        exitTransition = { _, _ ->
            fadeOut()
        },
        popExitTransition = { _, _ ->
            fadeOut()
        },
    ) {

        composable(NavDestinations.ROUTE_HOME) {

            val homeViewModel: HomeViewModel = hiltViewModel(it)

            HomeScreen(
                viewModel = homeViewModel
            )

        }

    }

}
