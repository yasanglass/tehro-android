package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelWheelchair

/**
 * Data access object for [AccessibilityLevelWheelchair].
 *
 * @see [MetroDatabase]
 */
@Dao
interface AccessibilityLevelWheelchairDAO {

    /**
     * @return A [AccessibilityLevelWheelchair] with the matching id if any exist.
     */
    @Query("SELECT * FROM stations_accessibility_wheelchair_levels WHERE id=:id")
    suspend fun getById(id: Int): AccessibilityLevelWheelchair?

}
