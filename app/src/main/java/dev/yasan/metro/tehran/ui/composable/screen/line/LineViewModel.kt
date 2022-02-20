package dev.yasan.metro.tehran.ui.composable.screen.line

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.kit.core.DispatcherProvider
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.repo.intersection.IntersectionRepository
import dev.yasan.metro.tehran.data.repo.line.LineRepository
import dev.yasan.metro.tehran.data.repo.station.StationRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [LineScreen]. Handles loading detailed data for one line.
 *
 * @see loadStations
 */
@HiltViewModel
class LineViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val stationRepository: StationRepository,
) : ViewModel() {

    companion object {
        private const val TAG = "LineViewModel"
    }

    private var _stations = MutableLiveData<Resource<List<Station>>>(Resource.Initial())
    val stations: LiveData<Resource<List<Station>>> get() = _stations

    /**
     * Loads station data into [_stations] (observable through [stations]).
     */
    fun loadStations(lineId: Int) {
        viewModelScope.launch(dispatchers.io) {
            Log.d(TAG, "loadStations: starting")
            _stations.postValue(Resource.Loading())
            try {
                val stationsList = stationRepository.getStations(lineId = lineId, complete = true)
                if (stationsList.isNotEmpty()) {
                    _stations.postValue(Resource.Success(data = stationsList))
                } else {
                    _stations.postValue(Resource.Error(messageResourceId = R.string.no_stations_found))
                }
            } catch (e: Exception) {
                Log.d(TAG, "loadStations: ${e.message}")
            }
        }
    }

}
