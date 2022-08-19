package dev.yasan.metro.tehran.domain.usecase.station

import dev.yasan.metro.tehran.domain.repository.station.StationRepository
import javax.inject.Inject

class GetStationsListUseCase @Inject constructor(
    private val stationRepository: StationRepository
) {

    suspend operator fun invoke(lineId: Int, complete: Boolean = false) =
        stationRepository.getStations(lineId = lineId, complete = complete)
}
