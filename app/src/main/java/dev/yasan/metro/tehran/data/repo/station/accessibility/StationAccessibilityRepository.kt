package dev.yasan.metro.tehran.data.repo.station.accessibility

import dev.yasan.metro.tehran.data.db.dao.StationLocationDAO
import dev.yasan.metro.tehran.data.db.entity.StationAccessibility

/**
 * Handles all data related to [StationAccessibility].
 */
interface StationAccessibilityRepository {

    /**
     * @return A list of all [StationAccessibility]s.
     *
     * @see StationLocationDAO
     */
    suspend fun getAll(): List<StationAccessibility>

    /**
     * @return A [StationAccessibility] with matching station id if any exist.
     *
     * @see StationLocationDAO
     */
    suspend fun getByStationId(stationId: Int): StationAccessibility?

}
