package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.StationAccessibility

/**
 * Data access object for [StationAccessibility].
 *
 * @see [MetroDatabase]
 */
@Dao
interface StationAccessibilityDAO {

    /**
     * @return A list of all [StationAccessibility]s in [MetroDatabase].
     */
    @Query("SELECT * FROM stations_accessibility")
    suspend fun getAll(): List<StationAccessibility>

    /**
     * @return A [StationAccessibility] with the matching station id if any exist.
     */
    @Query("SELECT * FROM stations_accessibility WHERE station_id=:stationId")
    suspend fun getByStationId(stationId: Int): StationAccessibility?
}
