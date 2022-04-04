package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.model.tehro.accessibility.AccessibilityLevelWheelchair

/**
 * Data access object for [AccessibilityLevelWheelchair].
 *
 * @see [MetroDatabase]
 */
@Dao
interface AccessibilityLevelWheelchairDAO {

    /**
     * @return A list of all [AccessibilityLevelWheelchair].
     */
    @Query("SELECT * FROM stations_accessibility_wheelchair_levels")
    suspend fun getAll(): List<AccessibilityLevelWheelchair>

    /**
     * @return A [AccessibilityLevelWheelchair] with the matching id if any exist.
     */
    @Query("SELECT * FROM stations_accessibility_wheelchair_levels WHERE id=:id")
    suspend fun getById(id: Int): AccessibilityLevelWheelchair?

}
