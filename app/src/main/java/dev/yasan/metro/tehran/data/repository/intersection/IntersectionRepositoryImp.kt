package dev.yasan.metro.tehran.data.repository.intersection

import dev.yasan.metro.tehran.data.source.local.database.dao.IntersectionDAO
import dev.yasan.metro.tehran.domain.entity.intersection.Intersection
import dev.yasan.metro.tehran.domain.repository.intersection.IntersectionRepository
import javax.inject.Inject

/**
 * The main implementation of [IntersectionRepository].
 */
class IntersectionRepositoryImp @Inject constructor(
    private val intersectionDAO: IntersectionDAO
) : IntersectionRepository {

    override suspend fun getIntersection(intersectionId: Int): Intersection? {
        return intersectionDAO.getById(intersectionId = intersectionId)
    }

    override suspend fun getIntersectionByStationId(stationId: Int): Intersection? {
        return intersectionDAO.getByStationId(stationId = stationId)
    }
}
