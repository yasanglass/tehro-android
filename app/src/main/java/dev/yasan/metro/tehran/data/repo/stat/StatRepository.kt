package dev.yasan.metro.tehran.data.repo.stat

import dev.yasan.metro.tehran.data.db.entity.Stat
import dev.yasan.metro.tehran.data.db.entity.StatComplex

/**
 * Handles all data related to [Stat].
 */
interface StatRepository {

    /**
     * @return A list of all basic statistics about the database.
     */
    suspend fun getBasicStatistics(): List<Stat>

    /**
     * @return A list of all complex statistics about the database.
     */
    suspend fun getComplexStatistics(): List<StatComplex>

}
