package dev.yasan.metro.tehran.data.repo.station.accessibility

import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelWheelchair

/**
 * Handles all data related to [Station] accessibility.
 */
interface AccessibilityRepository {

    /**
     * @return An [AccessibilityLevelBlindness] with the matching id if any exist.
     */
    suspend fun getBlindnessAccessibilityById(levelId: Int): AccessibilityLevelBlindness?

    /**
     * @return An [AccessibilityLevelWheelchair] with the matching id if any exist.
     */
    suspend fun getWheelchairAccessibilityById(levelId: Int): AccessibilityLevelWheelchair?

}
