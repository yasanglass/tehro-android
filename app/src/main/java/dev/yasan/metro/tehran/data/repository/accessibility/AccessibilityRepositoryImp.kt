package dev.yasan.metro.tehran.data.repository.accessibility

import dev.yasan.metro.tehran.data.source.local.database.dao.AccessibilityLevelBlindnessDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.AccessibilityLevelWheelchairDAO
import dev.yasan.metro.tehran.data.source.local.database.dao.WcAvailabilityLevelDAO
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.domain.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.domain.entity.accessibility.WcAvailabilityLevel
import dev.yasan.metro.tehran.domain.repository.accessibility.AccessibilityRepository
import javax.inject.Inject

/**
 * The main implementation of [AccessibilityRepository].
 */
class AccessibilityRepositoryImp @Inject constructor(
    private val accessibilityLevelWheelchairDAO: AccessibilityLevelWheelchairDAO,
    private val accessibilityLevelBlindnessDAO: AccessibilityLevelBlindnessDAO,
    private val wcAvailabilityLevelDAO: WcAvailabilityLevelDAO
) : AccessibilityRepository {

    override suspend fun getBlindnessAccessibilityList(): List<AccessibilityLevelBlindness> {
        return accessibilityLevelBlindnessDAO.getAll()
    }

    override suspend fun getBlindnessAccessibilityById(levelId: Int): AccessibilityLevelBlindness? {
        return accessibilityLevelBlindnessDAO.getById(id = levelId)
    }

    override suspend fun getWheelchairAccessibilityList(): List<AccessibilityLevelWheelchair> {
        return accessibilityLevelWheelchairDAO.getAll()
    }

    override suspend fun getWheelchairAccessibilityById(levelId: Int): AccessibilityLevelWheelchair? {
        return accessibilityLevelWheelchairDAO.getById(id = levelId)
    }

    override suspend fun getWcAvailabilityLevels(): List<WcAvailabilityLevel> {
        return wcAvailabilityLevelDAO.getAll()
    }

    override suspend fun getWcAvailabilityLevelById(levelId: Int): WcAvailabilityLevel? {
        return wcAvailabilityLevelDAO.getById(id = levelId)
    }
}
