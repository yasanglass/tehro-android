package dev.yasan.metro.tehran.domain.repository.line

import dev.yasan.metro.tehran.data.source.local.database.dao.LineDAO
import dev.yasan.metro.tehran.domain.entity.line.Line

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
