package dev.yasan.metro.tehran.ui.composable.screen.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.kit.core.DispatcherProvider
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.domain.repository.line.LineRepository
import dev.yasan.metro.tehran.domain.repository.station.StationRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [SearchScreen].
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val stationRepository: StationRepository,
    private val lineRepository: LineRepository
) : ViewModel() {

    companion object {
        private const val TAG = "SearchViewModel"
    }

    private var _results = MutableLiveData<Resource<Any>>(Resource.Initial())
    val results: LiveData<Resource<Any>> get() = _results

    fun search(query: String) {
        Log.d(TAG, "search: $query")
        viewModelScope.launch(dispatchers.io) {
        }
    }

}
