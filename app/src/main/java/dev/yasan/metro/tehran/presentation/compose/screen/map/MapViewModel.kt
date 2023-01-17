package dev.yasan.metro.tehran.presentation.compose.screen.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import glass.yasan.kit.core.DispatcherProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [MapScreen].
 */
@HiltViewModel
class MapViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
) : ViewModel() {

    companion object {
        private const val TAG = "MapViewModel"
    }

    private var _isLoaded = MutableLiveData(false)
    val isLoaded: LiveData<Boolean> get() = _isLoaded

    /**
     * Update [isLoaded] value. Updates the value to true by default.
     */
    fun setImageLoaded(loaded: Boolean = true) {
        viewModelScope.launch(dispatchers.io) {
            _isLoaded.postValue(loaded)
        }
    }
}
