package dev.yasan.metro.tehran.data.source.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.source.local.database.MetroDatabase
import dev.yasan.metro.tehran.domain.entity.station.Station

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
     * @return A [Station] that matches the query if any exist.
     */
    @Query(
        "SELECT * FROM stations WHERE name_en LIKE '%' || :query || '%' OR name_fa LIKE '%' || :query || '%' ORDER BY name_en COLLATE NOCASE ASC"
    )
    suspend fun search(query: String): List<Station>
}
