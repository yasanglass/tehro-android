package dev.yasan.metro.tehran.domain.usecase.station

import dev.yasan.metro.tehran.domain.repository.station.StationRepository
import javax.inject.Inject

class SearchStationsUseCase @Inject constructor(
    private val stationRepository: StationRepository
) {

    suspend operator fun invoke(query: String, complete: Boolean) =
        stationRepository.searchStations(query = query, complete = complete)
}
