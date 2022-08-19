package dev.yasan.metro.tehran.data.source.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.source.local.database.MetroDatabase
import dev.yasan.metro.tehran.domain.entity.intersection.Intersection

/**
 * Data access object for [Intersection].
 *
 * @see [MetroDatabase]
 */
@Dao
interface IntersectionDAO {

    /**
     * @return A list of all [Intersection]s in [MetroDatabase].
     */
    @Query("SELECT * FROM intersections")
    suspend fun getAll(): List<Intersection>

    /**
     * @return An [Intersection] with matching id if any exist.
     */
    @Query("SELECT * FROM intersections WHERE id=:intersectionId")
    suspend fun getById(intersectionId: Int): Intersection?

    /**
     * @return An [Intersection] with matching station id on [Intersection.stationA] or [Intersection.stationB] if any exist.
     */
    @Query("SELECT * FROM intersections WHERE :stationId IN(station_a, station_b)")
    suspend fun getByStationId(stationId: Int): Intersection?
}
