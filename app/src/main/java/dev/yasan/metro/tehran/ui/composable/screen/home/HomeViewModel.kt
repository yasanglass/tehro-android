package dev.yasan.metro.tehran.ui.composable.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.entity.DatabaseInformation
import dev.yasan.metro.tehran.data.repo.dbinfo.DatabaseInformationRepository
import dev.yasan.metro.tehran.util.DispatcherProvider
import dev.yasan.metro.tehran.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [HomeScreen]. Handles loading data exclusive to [HomeScreen]
 *
 * @see loadDatabaseInformation
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val databaseInformationRepository: DatabaseInformationRepository
) : ViewModel() {

    companion object {
        private const val TAG = "HomeViewModel"
    }

    private var _databaseInformation =
        MutableLiveData<Resource<DatabaseInformation>>(Resource.Initial())
    val databaseInformation: LiveData<Resource<DatabaseInformation>> get() = _databaseInformation

    /**
     * Loads database information into [_databaseInformation] (observable through [databaseInformation]).
     *
     * @see databaseInformation
     */
    fun loadDatabaseInformation() {
        viewModelScope.launch(dispatchers.io) {
            _databaseInformation.postValue(Resource.Loading())
            val data = databaseInformationRepository.getInformation()
            if (data != null) {
                _databaseInformation.postValue(Resource.Success(data = data))
            } else {
                _databaseInformation.postValue(Resource.Error(messageResourceId = R.string.failed_to_load_data))
            }
        }
    }
}
