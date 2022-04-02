package dev.yasan.metro.tehran.ui.composable.screen.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yasan.kit.core.DispatcherProvider
import dev.yasan.kit.core.Resource
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.model.tehro.DatabaseInformation
import dev.yasan.metro.tehran.model.tehro.Stat
import dev.yasan.metro.tehran.model.tehro.StatComplex
import dev.yasan.metro.tehran.domain.repository.dbinfo.DatabaseInformationRepository
import dev.yasan.metro.tehran.domain.repository.stat.StatRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for [AboutScreen].
 *
 * @see loadDatabaseInformation
 */
@HiltViewModel
class AboutViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val databaseInformationRepository: DatabaseInformationRepository,
    private val statRepository: StatRepository
) : ViewModel() {

    companion object {
        private const val TAG = "AboutViewModel"
    }

    private var _databaseInformation = MutableLiveData<Resource<DatabaseInformation>>(Resource.Initial())
    val databaseInformation: LiveData<Resource<DatabaseInformation>> get() = _databaseInformation

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

    private var _stats = MutableLiveData<Resource<List<Stat>>>(Resource.Initial())
    val stats: LiveData<Resource<List<Stat>>> get() = _stats

     fun loadBasicStats() {
        viewModelScope.launch(dispatchers.io) {
            _stats.postValue(Resource.Loading())
            val data = statRepository.getBasicStatistics()
            if (data.isNotEmpty()) {
                _stats.postValue(Resource.Success(data = data))
            } else {
                _stats.postValue(Resource.Error(messageResourceId = R.string.failed_to_load_data))
            }
        }
    }

    private var _statsComplex = MutableLiveData<Resource<List<StatComplex>>>(Resource.Initial())
    val statsComplex: LiveData<Resource<List<StatComplex>>> get() = _statsComplex

    fun loadComplexStats() {
        viewModelScope.launch(dispatchers.io) {
            _statsComplex.postValue(Resource.Loading())
            val data = statRepository.getComplexStatistics()
            if (data.isNotEmpty()) {
                _statsComplex.postValue(Resource.Success(data = data))
            } else {
                _statsComplex.postValue(Resource.Error(messageResourceId = R.string.failed_to_load_data))
            }
        }
    }

}
