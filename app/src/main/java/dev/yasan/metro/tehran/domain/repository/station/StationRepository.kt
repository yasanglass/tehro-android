package dev.yasan.metro.tehran.domain.repository.station

import dev.yasan.metro.tehran.data.source.local.database.dao.StationDAO
import dev.yasan.metro.tehran.domain.entity.station.Station

/**
 * Handles all data related to [Station].
 */
interface StationRepository {

    /**
     * @return A list of all [Station]s.
     *
     * @param complete If the all foreign keys should be loaded.
     * @param removeDuplicate If the duplicate intersections should be removed.
     *
     * @see StationDAO
     */
    suspend fun getStations(
        complete: Boolean = false,
        removeDuplicate: Boolean = false
    ): List<Station>

    /**
     * @return A list of all [Station]s in the line with the matching [lineId].
     *
     * @param complete If the all foreign keys should be loaded.
     *
     * @see StationDAO
     */
    suspend fun getStations(lineId: Int, complete: Boolean = false): List<Station>

    /**
     * @return A [Station] with matching id if any exist.
     *
     * @param complete If the all foreign keys should be loaded.
     *
     * @see StationDAO
     */
    suspend fun getStation(stationId: Int, complete: Boolean = false): Station?

    /**
     * Loads additional data into the [Station] object including interchange (if it has any)
     * and data inside the interchange (stations & lines inside stations).
     */
    suspend fun fetchAdditionalStationData(station: Station): Station

    /**
     * Loads additional data into the [Station] objects including interchange (if it has any)
     * and data inside the interchange (stations & lines inside stations).
     */
    suspend fun fetchAdditionalStationData(stations: List<Station>): List<Station>

    suspend fun searchStations(complete: Boolean, query: String): List<Station>
}
