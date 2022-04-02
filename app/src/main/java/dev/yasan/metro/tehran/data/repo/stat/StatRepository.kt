package dev.yasan.metro.tehran.data.repo.stat

import dev.yasan.metro.tehran.model.tehro.Stat
import dev.yasan.metro.tehran.model.tehro.StatComplex

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
