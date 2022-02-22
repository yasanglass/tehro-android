package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.data.db.entity.accessibility.WcAvailabilityLevel

/**
 * Data access object for [WcAvailabilityLevel].
 *
 * @see [MetroDatabase]
 */
@Dao
interface WcAvailabilityLevelDAO {

    /**
     * @return A [WcAvailabilityLevel] with the matching id if any exist.
     */
    @Query("SELECT * FROM stations_accessibility_wheelchair_levels WHERE id=:id")
    suspend fun getById(id: Int): WcAvailabilityLevel?

}
