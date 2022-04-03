package dev.yasan.metro.tehran.ui.navigation

import android.util.Log
import androidx.navigation.NavController
import dev.yasan.metro.tehran.model.tehro.Line
import dev.yasan.metro.tehran.ui.composable.screen.line.LineScreen

/**
 * Navigation helper object.
 * Navigation actions should go through this object so any potential future changes can be done in one place.
 */
object Navigator {

    private const val TAG = "Navigator"

    fun navigateToMap(navController: NavController) {
        navController.navigate(NavRoutes.routeMap())
    }

    /**
     * Navigates to [LineScreen].
     */
    fun navigateToLineDetails(navController: NavController, line: Line) {
        Log.d(TAG, "navigateToLineDetails: line ${line.nameEn}")
        navController.navigate(NavRoutes.routeLine(line = line)) {
            popUpTo(NavRoutes.routeLineBase()) {
                inclusive = true
            }
        }
    }

}