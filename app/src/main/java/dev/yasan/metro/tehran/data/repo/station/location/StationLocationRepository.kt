package dev.yasan.metro.tehran.data.repo.station.location

import dev.yasan.metro.tehran.data.db.dao.StationLocationDAO
import dev.yasan.metro.tehran.data.db.entity.StationLocation

/**
 * Handles all data related to [StationLocation].
 */
interface StationLocationRepository {

    /**
     * @return A list of all [StationLocation]s.
     *
     * @see StationLocationDAO
     */
    suspend fun getAll(): List<StationLocation>

    /**
     * @return A [StationLocation] with matching station id if any exist.
     *
     * @see StationLocationDAO
     */
    suspend fun getByStationId(stationId: Int): StationLocation?
}
