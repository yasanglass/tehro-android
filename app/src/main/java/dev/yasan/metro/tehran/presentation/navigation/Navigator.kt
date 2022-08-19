package dev.yasan.metro.tehran.presentation.navigation

import android.util.Log
import androidx.navigation.NavController
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.presentation.compose.screen.line.LineScreen
import dev.yasan.metro.tehran.presentation.util.entity.LaunchSource

/**
 * Navigation helper object.
 * Navigation actions should go through this object so any potential future changes can be done in one place.
 */
object Navigator {

    private const val TAG = "Navigator"

    fun navigateToSearch(navController: NavController) {
        navController.navigate(NavRoutes.routeSearch())
    }

    fun navigateToMap(navController: NavController) {
        navController.navigate(NavRoutes.routeMap())
    }

    /**
     * Navigates to [LineScreen].
     */
    fun navigateToLineDetails(
        navController: NavController,
        line: Line,
        launchSource: LaunchSource
    ) {
        Log.d(TAG, "navigateToLineDetails: line ${line.nameEn}")
        navController.navigate(NavRoutes.routeLine(line = line)) {
            popUpTo(if (launchSource == LaunchSource.LINE) NavRoutes.routeLineBase() else NavRoutes.routeSearch()) {
                inclusive = true
            }
        }
    }
}
