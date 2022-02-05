package dev.yasan.metro.tehran.data.repo.stat

import dev.yasan.metro.tehran.data.db.dao.LineDAO
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.db.entity.Stat

/**
 * Handles all data related to [Stat].
 */
interface StatRepository {

    /**
     * @return A list of all [Stat]s.
     */
    suspend fun getStatistics(): List<Stat>

}
