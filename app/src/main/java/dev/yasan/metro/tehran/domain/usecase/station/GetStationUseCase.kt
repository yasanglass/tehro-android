package dev.yasan.metro.tehran.domain.usecase.station

import dev.yasan.metro.tehran.domain.repository.station.StationRepository
import javax.inject.Inject

class GetStationUseCase @Inject constructor(
    private val stationRepository: StationRepository
) {

    suspend operator fun invoke(stationId: Int, complete: Boolean = false) =
        stationRepository.getStation(stationId = stationId, complete = complete)
}
