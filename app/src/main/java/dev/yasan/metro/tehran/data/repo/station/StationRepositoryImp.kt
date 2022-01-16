package dev.yasan.metro.tehran.data.repo.station

import dev.yasan.metro.tehran.data.db.dao.StationDAO
import dev.yasan.metro.tehran.data.db.entity.Station
import javax.inject.Inject

/**
 * The main implementation of [StationRepository].
 */
class StationRepositoryImp @Inject constructor(
    private val stationDAO: StationDAO
) : StationRepository {

    override suspend fun getStations(lineId: Int): List<Station> {
        return stationDAO.getByLineId(lineId = lineId)
    }

    override suspend fun getStation(stationId: Int): Station? {
        return stationDAO.getById(stationId = stationId)
    }
}
