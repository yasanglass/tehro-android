package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.StationLocation

/**
 * Data access object for [StationLocation].
 *
 * @see [MetroDatabase]
 */
@Dao
interface StationLocationDAO {

    /**
     * @return A list of all [StationLocation]s in [MetroDatabase].
     */
    @Query("SELECT * FROM station_locations")
    suspend fun getAll(): List<StationLocation>

    /**
     * @return A [StationLocation] with the matching station id if any exist.
     */
    @Query("SELECT * FROM station_locations WHERE station_id=:stationId")
    suspend fun getByStationId(stationId: Int): StationLocation?

}
