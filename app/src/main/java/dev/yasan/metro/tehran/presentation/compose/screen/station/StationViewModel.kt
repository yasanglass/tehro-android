package dev.yasan.metro.tehran.presentation.compose.screen.station

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.station.Station
import dev.yasan.metro.tehran.domain.usecase.station.GetStationUseCase
import glass.yasan.kit.core.DispatcherProvider
import glass.yasan.kit.core.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val getStationUseCase: GetStationUseCase
) : ViewModel() {

    private var _station = MutableLiveData<Resource<Station>>(Resource.Initial())
    val station: LiveData<Resource<Station>> get() = _station

    /**
     * Loads basic line data into [_station] (observable through [station]).
     */
    fun loadStation(stationId: Int) {
        viewModelScope.launch(dispatchers.io) {
            _station.postValue(Resource.Loading())
            val mStation = getStationUseCase(stationId = stationId, complete = true)
            if (mStation != null) {
                _station.postValue(Resource.Success(data = mStation))
            } else {
                _station.postValue(Resource.Error(messageResourceId = R.string.station_not_found))
            }
        }
    }
}
