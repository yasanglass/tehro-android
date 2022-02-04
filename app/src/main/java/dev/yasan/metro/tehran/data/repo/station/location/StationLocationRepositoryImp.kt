package dev.yasan.metro.tehran.data.repo.station.location

import dev.yasan.metro.tehran.data.db.dao.StationLocationDAO
import dev.yasan.metro.tehran.data.db.entity.StationLocation
import dev.yasan.metro.tehran.data.repo.station.StationRepository
import javax.inject.Inject

/**
 * The main implementation of [StationLocationRepository].
 */
class StationLocationRepositoryImp @Inject constructor(
    private val stationLocationDAO: StationLocationDAO
) : StationLocationRepository {

    override suspend fun getAll(): List<StationLocation> {
        return stationLocationDAO.getAll()
    }

    override suspend fun getByStationId(stationId: Int): StationLocation? {
        return stationLocationDAO.getByStationId(stationId = stationId)
    }

}
