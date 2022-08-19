package dev.yasan.metro.tehran.data.source.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.source.local.database.MetroDatabase
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelWheelchair

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
