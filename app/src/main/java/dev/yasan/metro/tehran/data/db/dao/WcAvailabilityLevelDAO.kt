package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.model.tehro.accessibility.WcAvailabilityLevel

/**
 * Data access object for [WcAvailabilityLevel].
 *
 * @see [MetroDatabase]
 */
@Dao
interface WcAvailabilityLevelDAO {

    /**
     * @return A list of all [WcAvailabilityLevel]s.
     */
    @Query("SELECT * FROM stations_wc_availability_levels")
    suspend fun getAll(): List<WcAvailabilityLevel>

    /**
     * @return A [WcAvailabilityLevel] with the matching id if any exist.
     */
    @Query("SELECT * FROM stations_wc_availability_levels WHERE id=:id")
    suspend fun getById(id: Int): WcAvailabilityLevel?

}
