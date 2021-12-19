package dev.yasan.metro.tehran.data.repo.line

import dev.yasan.metro.tehran.data.db.dao.LineDAO
import dev.yasan.metro.tehran.data.db.entity.Line
import javax.inject.Inject

class LineRepositoryImp @Inject constructor(
    private val lineDAO: LineDAO
) : LineRepository {

    override suspend fun getLines(): List<Line> {
        return lineDAO.get()
    }

}