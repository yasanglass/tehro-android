package dev.yasan.metro.tehran.presentation.compose.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.domain.usecase.line.GetLinesListUseCase
import glass.yasan.kit.core.DispatcherProvider
import glass.yasan.kit.core.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [HomeScreen]..
 *
 * @see loadLines
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val getLinesListUseCase: GetLinesListUseCase
) : ViewModel() {

    private var _lines = MutableLiveData<Resource<ArrayList<Line>>>(Resource.Initial())
    val lines: LiveData<Resource<ArrayList<Line>>> get() = _lines

    /**
     * Loads basic line data into [_lines] (observable through [lines]).
     */
    fun loadLines() {
        viewModelScope.launch(dispatchers.io) {
            _lines.postValue(Resource.Loading())
            val data = (getLinesListUseCase() as ArrayList).apply { sortBy { it.id } }
            if (data.isNotEmpty()) {
                _lines.postValue(Resource.Success(data = data))
            } else {
                _lines.postValue(Resource.Error(messageResourceId = R.string.no_lines_found))
            }
        }
    }
}
