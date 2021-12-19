package dev.yasan.metro.tehran.ui.composable.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.repo.line.LineRepository
import dev.yasan.metro.tehran.util.DispatcherProvider
import dev.yasan.metro.tehran.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val lineRepository: LineRepository
) : ViewModel() {

    private var _lines = MutableLiveData<Resource<ArrayList<Line>>>(Resource.Initial())
    val lines: LiveData<Resource<ArrayList<Line>>> get() = _lines

    fun loadLines() {
        viewModelScope.launch(dispatchers.io) {
            _lines.postValue(Resource.Loading())
            val data = (lineRepository.getLines() as ArrayList).apply { sortBy { it.id } }
            _lines.postValue(Resource.Success(data = data))
        }
    }

}