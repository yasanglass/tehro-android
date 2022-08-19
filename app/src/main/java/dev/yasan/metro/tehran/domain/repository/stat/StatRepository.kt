package dev.yasan.metro.tehran.domain.repository.stat

import dev.yasan.metro.tehran.domain.entity.stat.Stat
import dev.yasan.metro.tehran.domain.entity.stat.StatComplex

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
