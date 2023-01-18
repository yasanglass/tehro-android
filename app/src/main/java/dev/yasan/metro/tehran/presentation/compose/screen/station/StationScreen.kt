package dev.yasan.metro.tehran.presentation.compose.screen.station

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehError
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehErrorType
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehProgress
import dev.yasan.metro.tehran.presentation.compose.screen.station.modules.StationScreenSuccess
import dev.yasan.metro.tehran.presentation.util.entity.LaunchSource
import glass.yasan.kit.core.Resource

@Composable
fun StationScreen(
    stationViewModel: StationViewModel,
    navController: NavController,
    stationId: Int,
    launchSource: LaunchSource
) {
    fun loadData() {
        stationViewModel.loadStation(stationId = stationId)
    }

    val stationResource = stationViewModel.station.observeAsState(initial = Resource.Initial())

    when (stationResource.value) {
        is Resource.Initial -> {
            loadData()
        }
        is Resource.Error -> {
            TehError(type = TehErrorType.ERROR_GO_BACK) {
                loadData()
            }
        }
        is Resource.Success -> {
            val station = stationResource.value.data!!
            StationScreenSuccess(
                station = station,
                navController = navController,
                launchSource = launchSource
            )
        }
        else -> {
            TehProgress()
        }
    }
}
