package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.Interchange

/**
 * Data access object for [Interchange].
 *
 * @see [MetroDatabase]
 */
@Dao
interface InterchangeDAO {

    /**
     * @return A list of all [Interchange]s in [MetroDatabase].
     */
    @Query("SELECT * FROM interchanges")
    suspend fun getAll(): List<Interchange>

    /**
     * @return An [Interchange] with matching id if any exist.
     */
    @Query("SELECT * FROM interchanges WHERE id=:interchangeId")
    suspend fun getById(interchangeId: Int): Interchange?

    /**
     * @return An [Interchange] with matching station id on [Interchange.stationA] or [Interchange.stationB] if any exist.
     */
    @Query("SELECT * FROM interchanges WHERE :stationId IN(station_a, station_b)")
    suspend fun getByStationId(stationId: Int): Interchange?
}
