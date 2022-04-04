package dev.yasan.metro.tehran.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import dev.yasan.metro.tehran.data.db.MetroDatabase
import dev.yasan.metro.tehran.model.tehro.accessibility.AccessibilityLevelBlindness

/**
 * Data access object for [AccessibilityLevelBlindness].
 *
 * @see [MetroDatabase]
 */
@Dao
interface AccessibilityLevelBlindnessDAO {

    /**
     * @return A list of all [AccessibilityLevelBlindness].
     */
    @Query("SELECT * FROM stations_accessibility_blindness_levels")
    suspend fun getAll(): List<AccessibilityLevelBlindness>

    /**
     * @return A [AccessibilityLevelBlindness] with the matching id if any exist.
     */
    @Query("SELECT * FROM stations_accessibility_blindness_levels WHERE id=:id")
    suspend fun getById(id: Int): AccessibilityLevelBlindness?

}
