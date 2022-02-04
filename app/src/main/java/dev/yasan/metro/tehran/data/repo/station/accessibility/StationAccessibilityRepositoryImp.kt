package dev.yasan.metro.tehran.data.repo.station.accessibility

import dev.yasan.metro.tehran.data.db.dao.StationAccessibilityDAO
import dev.yasan.metro.tehran.data.db.entity.StationAccessibility
import javax.inject.Inject

/**
 * The main implementation of [StationAccessibilityRepository].
 */
class StationAccessibilityRepositoryImp @Inject constructor(
    private val stationAccessibilityDAO: StationAccessibilityDAO
) : StationAccessibilityRepository {

    override suspend fun getAll(): List<StationAccessibility> {
        return stationAccessibilityDAO.getAll()
    }

    override suspend fun getByStationId(stationId: Int): StationAccessibility? {
        return stationAccessibilityDAO.getByStationId(stationId = stationId)
    }
}
