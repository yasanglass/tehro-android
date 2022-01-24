package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.Station

/**
 * Data access object for [Station].
 *
 * @see [MetroDatabase]
 */
@Dao
interface StationDAO {

    /**
     * @return A list of all [Station]s in [MetroDatabase].
     */
    @Query("SELECT * FROM stations")
    suspend fun getAll(): List<Station>

    /**
     * @return A [Station] with the matching id if any exist.
     */
    @Query("SELECT * FROM stations WHERE id=:stationId")
    suspend fun getById(stationId: Int): Station?

    /**
     * @return A [Station] with matching line id if any exist.
     */
    @Query("SELECT * FROM stations WHERE line_id=:lineId")
    suspend fun getByLineId(lineId: Int): List<Station>

    /**
     * @return A list of [Station]s with matching interchange ids.
     */
    @Query("SELECT * FROM stations WHERE intersection_id=:intersectionId")
    suspend fun getByIntersectionId(intersectionId: Int): List<Station>
}
