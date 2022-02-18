package dev.yasan.metro.tehran.ui.composable.screen.line

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import dev.yasan.kit.compose.foundation.grid
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.db.entity.LineType
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.ui.composable.common.teh.*
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
    line: Line?
) {

    val stations = lineViewModel.stations.observeAsState()

    if (stations.value is Resource.Initial) {
        lineViewModel.loadStations(lineId = line?.id ?: 0)
    }

    val title: String = when {
        line != null -> {
            when (line.type) {
                LineType.METRO_BRANCH ->
                    "${stringResource(id = R.string.line)} ${line.name} (${stringResource(id = R.string.branch)})"
                else -> "${stringResource(id = R.string.line)} ${line.name}"
            }
        }
        else -> stringResource(id = R.string.error)
    }

    TehScreen(
        title = title,
        color = line?.color ?: Color.DarkGray
    ) {

        if (line != null) {

            when (stations.value) {
                is Resource.Error -> {
                    item {
                        TehError {
                            lineViewModel.loadStations(lineId = line.id)
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
        } else {

            item {
                TehError(
                    title = stringResource(id = R.string.line_not_found),
                    type = TehErrorType.ERROR_GO_BACK
                ) {
                    navController.navigateUp()
                }
            }
        }
    }
}
