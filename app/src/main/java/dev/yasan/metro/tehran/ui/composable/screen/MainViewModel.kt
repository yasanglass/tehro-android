package dev.yasan.metro.tehran.ui.composable.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.kit.core.DispatcherProvider
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.repo.line.LineRepository
import dev.yasan.metro.tehran.ui.composable.screen.home.HomeScreen
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Shared ViewModel in the whole Tehro application.
 * Its the main ViewModel of [HomeScreen] and the additional ViewModel for the rest of the navigation routes.
 *
 * @see loadLines
 * @see getLineById
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val lineRepository: LineRepository
) : ViewModel() {

    private var _lines = MutableLiveData<Resource<ArrayList<Line>>>(Resource.Initial())
    val lines: LiveData<Resource<ArrayList<Line>>> get() = _lines

    /**
     * Loads basic line data into [_lines] (observable through [lines]).
     */
    fun loadLines() {
        viewModelScope.launch(dispatchers.io) {
            _lines.postValue(Resource.Loading())
            val data = (lineRepository.getLines() as ArrayList).apply { sortBy { it.id } }
            if (data.isNotEmpty()) {
                _lines.postValue(Resource.Success(data = data))
            } else {
                _lines.postValue(Resource.Error(messageResourceId = R.string.no_lines_found))
            }
        }
    }

    /**
     * Fetches a line using an id from the already loaded lines list in [MainViewModel].
     * This is used as a "faster" alternative to loading the line directly from [MetroDatabase].
     */
    fun getLineById(lineId: Int): Line? {
        _lines.value?.data?.forEach { line ->
            if (line.id == lineId) return line
        }
        return null
    }
}
