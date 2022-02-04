package dev.yasan.metro.tehran.data.repo.stat

import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.data.db.dao.*
import dev.yasan.metro.tehran.data.db.entity.Line
import dev.yasan.metro.tehran.data.db.entity.Stat
import javax.inject.Inject

/**
 * The main implementation of [StatRepository].
 */
class StatRepositoryImp @Inject constructor(
    private val intersectionDAO: IntersectionDAO,
    private val lineDAO: LineDAO,
    private val stationAccessibilityDAO: StationAccessibilityDAO,
    private val stationDAO: StationDAO,
    private val stationLocationDAO: StationLocationDAO
) : StatRepository {

    override suspend fun getStatistics(): List<Stat> {
        val intersectionCount = intersectionDAO.getAll().size
        val lineCount = lineDAO.getAll().size
        val stationCount = stationDAO.getAll().size
        val stationAccessibilityCount = stationAccessibilityDAO.getAll().size
        val stationLocationCount = stationLocationDAO.getAll().size

        return listOf(
            Stat(title = R.string.lines, lineCount),
            Stat(title = R.string.stations, stationCount),
            Stat(title = R.string.intersections, intersectionCount),
        )
    }

}
