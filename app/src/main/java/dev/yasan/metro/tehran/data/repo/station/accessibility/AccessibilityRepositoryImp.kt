package dev.yasan.metro.tehran.data.repo.station.accessibility

import android.util.Log
import dev.yasan.metro.tehran.data.db.dao.AccessibilityLevelBlindnessDAO
import dev.yasan.metro.tehran.data.db.dao.AccessibilityLevelWheelchairDAO
import dev.yasan.metro.tehran.data.db.dao.StationDAO
import dev.yasan.metro.tehran.data.db.entity.Station
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelBlindness
import dev.yasan.metro.tehran.data.db.entity.accessibility.AccessibilityLevelWheelchair
import dev.yasan.metro.tehran.data.repo.intersection.IntersectionRepository
import dev.yasan.metro.tehran.data.repo.line.LineRepository
import javax.inject.Inject

/**
 * The main implementation of [AccessibilityRepository].
 */
class AccessibilityRepositoryImp @Inject constructor(
    private val accessibilityLevelWheelchairDAO: AccessibilityLevelWheelchairDAO,
    private val accessibilityLevelBlindnessDAO: AccessibilityLevelBlindnessDAO,
) : AccessibilityRepository {

    override suspend fun getBlindnessAccessibilityById(levelId: Int): AccessibilityLevelBlindness? {
       return accessibilityLevelBlindnessDAO.getById(id = levelId)
    }

    override suspend fun getWheelchairAccessibilityById(levelId: Int): AccessibilityLevelWheelchair? {
        return accessibilityLevelWheelchairDAO.getById(id = levelId)
    }


}
