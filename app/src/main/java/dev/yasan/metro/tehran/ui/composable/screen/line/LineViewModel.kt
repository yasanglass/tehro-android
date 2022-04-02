package dev.yasan.metro.tehran.ui.composable.screen.line

import android.app.Application
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.kit.core.DispatcherProvider
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Station
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
    application: Application,
    private val dispatchers: DispatcherProvider,
    private val stationRepository: StationRepository,
    private val lineRepository: LineRepository
) : AndroidViewModel(application) {

    companion object {
        private const val TAG = "LineViewModel"
    }

    private var _stations = MutableLiveData<Resource<List<Station>>>(Resource.Initial())
    val stations: LiveData<Resource<List<Station>>> get() = _stations

    private var _title = MutableLiveData("Line")
    val title: LiveData<String> get() = _title

    private var _lineColor = MutableLiveData<Color>(Color.DarkGray)
    val lineColor: LiveData<Color> get() = _lineColor

    /**
     * Loads station data into [_stations] (observable through [stations]).
     */
    fun loadStations(lineId: Int) {
        viewModelScope.launch(dispatchers.io) {
            Log.d(TAG, "loadStations: $lineId")
            _stations.postValue(Resource.Loading())
            val line = lineRepository.getLine(lineId = lineId)
            if (line != null) {
                _title.postValue(line.getFullName(context = getApplication()))
                _lineColor.postValue(line.color)
                val stationsList = stationRepository.getStations(lineId = lineId, complete = true)
                if (stationsList.isNotEmpty()) {
                    _stations.postValue(Resource.Success(data = stationsList))
                } else {
                    _stations.postValue(Resource.Error(messageResourceId = R.string.no_stations_found))
                }
            } else {
                _stations.postValue(Resource.Error(messageResourceId = R.string.line_not_found))
            }
        }
    }

}
