package dev.yasan.metro.tehran.data.repo.intersection

import dev.yasan.metro.tehran.data.db.dao.IntersectionDAO
import dev.yasan.metro.tehran.data.db.entity.Intersection
import javax.inject.Inject

/**
 * The main implementation of [IntersectionRepository].
 */
class IntersectionRepositoryImp @Inject constructor(
    private val IntersectionDAO: IntersectionDAO
) : IntersectionRepository {

    override suspend fun getIntersection(interchangeId: Int): Intersection? {
        return IntersectionDAO.getById(intersectionId = interchangeId)
    }
}
