package dev.yasan.metro.tehran.ui.composable.screen.station

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.ui.composable.common.teh.TehError
import dev.yasan.metro.tehran.ui.composable.common.teh.TehErrorType
import dev.yasan.metro.tehran.ui.composable.common.teh.TehProgress
import dev.yasan.metro.tehran.ui.composable.screen.station.modules.StationScreenSuccess

@Composable
fun StationScreen(
    stationViewModel: StationViewModel,
    navController: NavController,
    stationId: Int
) {

    fun loadData() {
        stationViewModel.loadStation(stationId = stationId)
    }

    val stationResource = stationViewModel.station.observeAsState()

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
            val station = stationResource.value!!.data!!
            StationScreenSuccess(station = station, navController = navController)
        }
        else -> {
            TehProgress()
        }
    }
}
