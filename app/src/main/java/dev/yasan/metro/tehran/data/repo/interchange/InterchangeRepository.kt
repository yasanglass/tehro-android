package dev.yasan.metro.tehran.data.repo.interchange

import dev.yasan.metro.tehran.data.db.dao.InterchangeDAO
import dev.yasan.metro.tehran.data.db.entity.Interchange

/**
 * Handles all data related to [Interchange].
 */
interface InterchangeRepository {

    /**
     * @return A [Interchange] with matching id if any exist.
     *
     * @see InterchangeDAO
     */
    suspend fun getInterchange(interchangeId: Int): Interchange?
}
