package dev.yasan.metro.tehran.domain.repository.accessibility

import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.domain.entity.accessibility.WcAvailabilityLevel
import dev.yasan.metro.tehran.domain.entity.station.Station

/**
 * Handles all data related to [Station] accessibility.
 */
interface AccessibilityRepository {

    /**
     * @return A list of all [AccessibilityLevelBlindness]s.
     */
    suspend fun getBlindnessAccessibilityList(): List<AccessibilityLevelBlindness>

    /**
     * @return An [AccessibilityLevelBlindness] with the matching id if any exist.
     */
    suspend fun getBlindnessAccessibilityById(levelId: Int): AccessibilityLevelBlindness?

    /**
     * @return A list of all [AccessibilityLevelWheelchair]s.
     */
    suspend fun getWheelchairAccessibilityList(): List<AccessibilityLevelWheelchair>

    /**
     * @return An [AccessibilityLevelWheelchair] with the matching id if any exist.
     */
    suspend fun getWheelchairAccessibilityById(levelId: Int): AccessibilityLevelWheelchair?

    /**
     * @return A list of all [WcAvailabilityLevel]s.
     */
    suspend fun getWcAvailabilityLevels(): List<WcAvailabilityLevel>

    /**
     * @return An [WcAvailabilityLevel] with the matching id if any exist.
     */
    suspend fun getWcAvailabilityLevelById(levelId: Int): WcAvailabilityLevel?
}
