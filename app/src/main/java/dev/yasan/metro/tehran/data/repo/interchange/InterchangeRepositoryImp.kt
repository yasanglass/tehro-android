package dev.yasan.metro.tehran.data.repo.interchange

import dev.yasan.metro.tehran.data.db.dao.InterchangeDAO
import dev.yasan.metro.tehran.data.db.entity.Interchange
import javax.inject.Inject

/**
 * The main implementation of [InterchangeRepository].
 */
class InterchangeRepositoryImp @Inject constructor(
    private val interchangeDAO: InterchangeDAO
) : InterchangeRepository {

    override suspend fun getInterchange(interchangeId: Int): Interchange? {
        return interchangeDAO.getById(interchangeId = interchangeId)
    }
}
