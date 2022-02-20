package dev.yasan.metro.tehran.ui.composable.screen.station

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

@HiltViewModel
class StationViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val stationRepository: StationRepository,
    private val intersectionRepository: IntersectionRepository,
    private val lineRepository: LineRepository,
) : ViewModel() {

    private var _station = MutableLiveData<Resource<Station>>(Resource.Initial())
    val station: LiveData<Resource<Station>> get() = _station

    /**
     * Loads basic line data into [_station] (observable through [station]).
     */
    fun loadStation(stationId: Int) {
        viewModelScope.launch(dispatchers.io) {
            _station.postValue(Resource.Loading())
            val mStation = stationRepository.getStation(stationId = stationId)
            if (mStation != null) {

                // TODO

               /* // Location
                stationLocationRepository.getByStationId(stationId = stationId)
                    ?.let { mStation.location = it }

                // Accessibility
                stationAccessibilityRepository.getByStationId(stationId = stationId)
                    ?.let { mStation.accessibility = it }

                // Intersection
                mStation.intersectionId?.let { interchangeId ->
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
                                mStation.intersection = it
                            }
                        }
                }*/

                _station.postValue(Resource.Success(data = mStation))
            } else {
                _station.postValue(Resource.Error(messageResourceId = R.string.station_not_found))
            }
        }
    }
}
