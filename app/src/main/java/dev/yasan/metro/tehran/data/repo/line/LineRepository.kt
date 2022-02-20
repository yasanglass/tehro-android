package dev.yasan.metro.tehran.data.repo.line

import dev.yasan.metro.tehran.data.db.dao.LineDAO
import dev.yasan.metro.tehran.data.db.entity.Line

/**
 * Handles all data related to [Line].
 */
interface LineRepository {

    /**
     * @return A list of all [Line]s.
     *
     * @see LineDAO
     */
    suspend fun getLines(): List<Line>

    /**
     * @return A [Line] with matching id if any exist.
     *
     * @see LineDAO
     */
    suspend fun getLine(lineId: Int): Line?

}
