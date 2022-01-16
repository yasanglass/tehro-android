package dev.yasan.metro.tehran.data.repo.station

import dev.yasan.metro.tehran.data.db.dao.StationDAO
import dev.yasan.metro.tehran.data.db.entity.Station

/**
 * Handles all data related to [Station].
 */
interface StationRepository {

    /**
     * @return A list of all [Station]s.
     *
     * @see StationDAO
     */
    suspend fun getStations(lineId: Int): List<Station>

    /**
     * @return A [Station] with matching id if any exist.
     *
     * @see StationDAO
     */
    suspend fun getStation(stationId: Int): Station?
}
