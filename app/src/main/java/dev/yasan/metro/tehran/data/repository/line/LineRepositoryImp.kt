package dev.yasan.metro.tehran.data.repository.line

import dev.yasan.metro.tehran.data.source.local.database.dao.LineDAO
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.domain.repository.line.LineRepository
import javax.inject.Inject

/**
 * The main implementation of [LineRepository].
 */
class LineRepositoryImp @Inject constructor(
    private val lineDAO: LineDAO
) : LineRepository {

    override suspend fun getLines(): List<Line> {
        return lineDAO.getAll()
    }

    override suspend fun getLine(lineId: Int): Line? {
        return lineDAO.getById(lineId = lineId)
    }
}
