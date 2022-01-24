package dev.yasan.metro.tehran.ui.composable.screen.station

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.repo.station.StationRepository
import dev.yasan.metro.tehran.util.DispatcherProvider
import dev.yasan.metro.tehran.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val stationRepository: StationRepository
) : ViewModel() {

    private var _station = MutableLiveData<Resource<Station>>(Resource.Initial())
    val station: LiveData<Resource<Station>> get() = _station

    /**
     * Loads basic line data into [_station] (observable through [station]).
     */
    fun loadStation(stationId: Int) {
        viewModelScope.launch(dispatchers.io) {
            _station.postValue(Resource.Loading())
            val data = stationRepository.getStation(stationId = stationId)
            if (data != null) {
                _station.postValue(Resource.Success(data = data))
            } else {
                _station.postValue(Resource.Error(messageResourceId = R.string.station_not_found))
            }
        }
    }

}
