package dev.yasan.metro.tehran.ui.composable.screen.line

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.kit.library.util.DispatcherProvider
import dev.yasan.kit.library.util.Resource
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
    private val intersectionRepository: IntersectionRepository,
    private val lineRepository: LineRepository
) : ViewModel() {

    companion object {
        private const val TAG = "LineViewModel"
    }

    private var _stations = MutableLiveData<Resource<ArrayList<Station>>>(Resource.Initial())
    val stations: LiveData<Resource<ArrayList<Station>>> get() = _stations

    /**
     * Loads station data into [_stations] (observable through [stations]).
     *
     * If the station has an interchange, the interchange data is fetched.
     * Then the station data for stationA & stationB of the interchange are fetched.
     * Then the line data for stationA & stationB are fetched.
     */
    // TODO reduce the complexity of this. It might require database schema adjustments but this is a bit too much for so little information.
    fun loadStations(lineId: Int) {
        viewModelScope.launch(dispatchers.io) {
            _stations.postValue(Resource.Loading())
            val stationsList =
                (stationRepository.getStations(lineId = lineId) as ArrayList).apply {
                    // Sort stations
                    sortBy { it.positionInLine }
                    forEach { station ->
                        station.intersectionId?.let { interchangeId ->
                            // Load interchange data for station
                            intersectionRepository.getIntersection(interchangeId = interchangeId)
                                ?.let {
                                    it.stationA =
                                        stationRepository.getStation(stationId = it.stationIdA)
                                            ?.apply {
                                                line =
                                                    lineRepository.getLine(lineId = this.lineId)
                                            }
                                    it.stationB =
                                        stationRepository.getStation(stationId = it.stationIdB)
                                            ?.apply {
                                                line =
                                                    lineRepository.getLine(lineId = this.lineId)
                                            }

                                    if (it.hasBothStations()) {
                                        // Only use the interchange data if both stations are properly loaded
                                        station.intersection = it
                                    }
                                }
                        }
                    }
                }
            if (stationsList.isNotEmpty()) {
                _stations.postValue(Resource.Success(data = stationsList))
            } else {
                _stations.postValue(Resource.Error(messageResourceId = R.string.no_stations_found))
            }
        }
    }
}
