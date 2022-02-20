package dev.yasan.metro.tehran.data.repo.stat

import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.dao.*
import dev.yasan.metro.tehran.data.db.entity.Stat
import javax.inject.Inject

/**
 * The main implementation of [StatRepository].
 */
class StatRepositoryImp @Inject constructor(
    private val intersectionDAO: IntersectionDAO,
    private val lineDAO: LineDAO,
    private val stationDAO: StationDAO,
) : StatRepository {

    override suspend fun getStatistics(): List<Stat> {
        val intersectionCount = intersectionDAO.getAll().size
        val lineCount = lineDAO.getAll().size
        val stationCount = stationDAO.getAll().size - intersectionCount / 2

        return listOf(
            Stat(titleStringResourceId = R.string.stations, stationCount),
            Stat(titleStringResourceId = R.string.intersections, intersectionCount),
            Stat(titleStringResourceId = R.string.lines, lineCount),
        )

    }

}
