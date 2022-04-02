package dev.yasan.metro.tehran.ui.composable.screen.line

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.yasan.kit.compose.foundation.grid
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.ui.composable.common.teh.TehError
import dev.yasan.metro.tehran.ui.composable.common.teh.TehFooter
import dev.yasan.metro.tehran.ui.composable.common.teh.TehProgress
import dev.yasan.metro.tehran.ui.composable.common.teh.TehScreen
import dev.yasan.metro.tehran.ui.composable.screen.line.modules.StationItem
import dev.yasan.metro.tehran.ui.navigation.NavGraph
import dev.yasan.metro.tehran.ui.navigation.NavRoutes

/**
 * This screen shows the detailed data for a single [Line] which mainly includes the list of [Station]s inside it.
 *
 * @see NavGraph
 * @see NavRoutes.routeLine
 * @see NavRoutes.routeLineBase
 */
@Composable
fun LineScreen(
    lineViewModel: LineViewModel,
    navController: NavController,
    lineId: Int,
) {

    val title = lineViewModel.title.observeAsState()
    val lineColor = lineViewModel.lineColor.observeAsState()
    val stations = lineViewModel.stations.observeAsState()

    rememberSystemUiController().setStatusBarColor(color = lineColor.value ?: Color.DarkGray)

    LaunchedEffect(key1 = stations.value) {
        if (stations.value is Resource.Initial) {
            lineViewModel.loadStations(lineId = lineId)
        }
    }

    TehScreen(
        title = title.value ?: "",
        color = lineColor.value ?: Color.DarkGray
    ) {

        when (stations.value) {
            is Resource.Error -> {
                item {
                    TehError {
                        lineViewModel.loadStations(lineId = lineId)
                    }
                }
            }
            is Resource.Success -> {

                val list = stations.value?.data ?: ArrayList()
                val stationCount = list.size

                item {
                    Spacer(modifier = Modifier.requiredHeight(grid()))
                }

                items(
                    items = list,
                    key = { it.id }
                ) { station ->
                    StationItem(
                        station = station,
                        navController = navController,
                    )
                }

                item {
                    TehFooter(text = stringResource(R.string.n_stations, stationCount))
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
